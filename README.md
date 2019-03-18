# EasyBle
ble 4.0
```
QQ : 695344490
Email : pengle609@163.com
```

### Gradle（预计）
~~ ` compile 'com.microape.easyble:easyble:1.0.0' ` ~~

## Usage

> ### 前提条件
> 1. 设备是否支持WiFi
> 2. 6.0手机是否允许定位权限（影响扫描）

### init 
` EasyBle.newInstance().init(this); `

### 设置监听
```
easyBle.setOpenCallBack(this);
easyBle.setScanCallBack(this);
easyBle.setConnCallBack(this);
```

### 开启WiFi
` easyBle.enable(); `

### 关闭WiFi
` easyBle.disable(); `

### 扫描WiFi
` easyBle.startScan(); `

### 连接指定WiFi、并建立通讯(后续更新)
```


```

### 感谢
* PermissionsDispatcher
