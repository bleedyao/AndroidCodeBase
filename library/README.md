# 关于 AndroidCodeBase
AndroidCodeBase 是一个 Android 代码的仓库，用于对经常使用的控件，进行封装，减少重复代码，提高代码的复用性，同时也不失去应用的性能。

目前支持 `RecyclerView` 的 `adapter` 和 `ViewHolder` 的封装

# 使用

##  RecyclerView 相关封装

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