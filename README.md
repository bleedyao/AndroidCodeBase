# AndroidCodeBase [![](https://jitpack.io/v/bleedyao/AndroidCodeBase.svg)](https://jitpack.io/#bleedyao/AndroidCodeBase)

AndroidCodeBase 是一个 Android 代码的仓库，用于对经常使用的控件，进行封装，减少重复代码，提高代码的复用性，同时也不失去应用的性能。

## 添加依赖

**Step 1.** Add it in your root build.gradle at the end of repositories:

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```groovy
	dependencies {
	        compile 'com.github.bleedyao:AndroidCodeBase:lastest_version'
	}
```

## 相关封装

- [x] 支持 `RecyclerView` 的 `adapter` 和 `ViewHolder` 的封装
- [x] 封装 mqtt 协议的相关数据
- [ ] Retrofit 和 Rxjava 的封装
- [x] Fragment 懒加载封装

### RecyclerView 相关封装

* 单布局适配器：继承 `BaseAdapter<String>`  泛型为数据类型
  * 需要传递上下文，数据集合，条目布局，创建适配器
  * 在 onBind 中实现数据绑定和条目中控件的点击事件
  * 其中控件的点击事件可以通过 `holder.setOnClickListener(控件 id，监听的子类)`
  * 长点击与点击事件相同
  * 给整个条目设置点击事件，可以通过自定义的 `adapter.setOnItemClickListener(OnItemClickListener 的子类)`实现
* 多布局适配器：继承 `MultiLayoutsBaseAdapter<Content>` 泛型为数据类型
  * `MultiLayoutsBaseAdapter` 是 `BaseAdapter` 的子类，需要传递布局的数组
  * getItemType 返回布局类型
  * onBinds 中设置布局以及绑定数据
* 分割线可以使用系统自带 DividerItemDecoration
* 添加和删除动画可以使用默认动画


注：你也可以全部使用多布局适配器，以应对可能会发生改变的需求。

### mqtt 相关说明

使用 mqtt 传输协议，必须执行一下操作

* 添加一下权限

```html
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```

* 注册 mqtt 服务

```html
<!-- Mqtt Service -->
<service android:name="org.eclipse.paho.android.service.MqttService"/>
```

### 懒加载模块封装
* 懒加载功能需要和 ViewPager 配合使用
* 需要实现懒加载功能的 fragment 需要继承 LazyFragment 
* ViewPager 需要设置 setOffscreenPageLimit() 数量，其数量为 fragment 数量 - 1
* loadData() 所在的线程为主线程，如需处理耗时操作，请自行开启线程
