
# databinding（界面与代码的解耦，简洁明快）
1. 先在model里面配置启用databinding
~~~~
    dataBinding{
        enabled true
    }
~~~~
2. 在xml界面操作：convert to data binding layout
3. 通过onSaveInstanceState保存，应用在后台因内存等被退了也可以保存数据。
