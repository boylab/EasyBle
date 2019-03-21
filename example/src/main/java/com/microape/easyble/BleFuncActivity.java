package com.microape.easyble;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.microape.easyble.common.callback.OnBleConnCallBack;
import com.microape.easyble.common.callback.OnBleOpenCallBack;
import com.microape.easyble.common.callback.OnBleScanCallBack;

import java.util.ArrayList;

public class BleFuncActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, OnBleOpenCallBack, OnBleScanCallBack, OnBleConnCallBack {

    private Button btn_OpenBT, btn_CloseBT, btn_DiscoveryBT;
    private ListView lv_BTList;
    private BleListAdapter bleListAdapter;
    private ArrayList<BluetoothDevice> bluetoothDevices = new ArrayList<>();

    private EasyBle easyBT = EasyBle.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blefunc);

        btn_OpenBT = findViewById(R.id.btn_OpenBT);
        btn_CloseBT = findViewById(R.id.btn_CloseBT);
        btn_DiscoveryBT = findViewById(R.id.btn_DiscoveryBT);
        lv_BTList = findViewById(R.id.lv_BTList);
        bleListAdapter = new BleListAdapter(this, bluetoothDevices);
        lv_BTList.setAdapter(bleListAdapter);

        btn_OpenBT.setOnClickListener(this);
        btn_CloseBT.setOnClickListener(this);
        btn_DiscoveryBT.setOnClickListener(this);
        lv_BTList.setOnItemClickListener(this);

        easyBT.setOpenCallBack(this);
        easyBT.setScanCallBack(this);
        easyBT.setConnCallBack(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_OpenBT:
                easyBT.enable();
                break;
            case  R.id.btn_CloseBT:
                easyBT.disable();
                break;
            case  R.id.btn_DiscoveryBT:
                easyBT.startDiscovery();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onBleEnable() {
        Toast.makeText(this, "蓝牙打开！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBleDisable() {
        Toast.makeText(this, "蓝牙关闭！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBleDiscoveryStarted() {
        Toast.makeText(this, "蓝牙扫描开始！", Toast.LENGTH_SHORT).show();
        bluetoothDevices.clear();
        bleListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBleFound(BluetoothDevice device) {
        bluetoothDevices.add(device);
        bleListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBleDiscoveryFinished() {
        if (bluetoothDevices.isEmpty()){
            Toast.makeText(this, "蓝牙结束，未扫到！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "蓝牙结束！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBleConnectFail() {
        Toast.makeText(this, "蓝牙连接失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBleConnected() {
        Toast.makeText(this, "蓝牙连接成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBleDisConnected() {
        Toast.makeText(this, "蓝牙断开连接！", Toast.LENGTH_SHORT).show();
    }
}
