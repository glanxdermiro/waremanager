# waremanager
Java课设--仓库管理系统
无框架，纯java，控制台输入输出

# 项目介绍
## 注册
输入用户名、密码、确认密码，注册新用户
## 登录
通过用户名和密码登录
## 仓库管理
1、仓库查询
可以根据用户输入的数据按照仓库名称或仓库类型查询仓库。
展示项包括：仓库标识当编号用了、仓库名称、仓库容量、仓库地址。

2、新建仓库
输入项：仓库名称、仓库容量、仓库地址。

3、修改仓库
首先在仓库列表中选中仓库，然后对仓库数据进行修改
输入项：仓库名称、仓库容量、仓库地址。
注意：修改容量要判断当前仓库存放的货物容量是否充足。

4、删除仓库
删除在列表中选中的仓库。
注意：删除仓库要判断仓库是否有货物，如果有货物不允许删除。

5、添加库存
首先选择仓库，添加库存。
输入项：库存容量、库存已用容量、库存预警容量、库存类型。
注意：要校验库存容量是否超过仓库容量。
## 库存管理
1、库存查询
分页展示库存数据，每页10条数据。
展示项包括：库存标识、仓库名称、库存类型、库存最大容量、库存已用容量、预警容量、仓库地址。

2、产品入库
输入产品编号、数量，根据产品编号和数量查询可以存放产品的库存，选择要存放的库存，将产品存入仓库。
产品数据不需要系统维护，从产品表中获取。
注意：存入产品要根据类型校验库存是否可以存放该产品。例如，冰淇淋不能存放在常温仓库中。同样产品数量和库存容量也要做校验。

3、产品出库
输入产品编号、数量，根据产品编号和数量查询满足条件的库存，选择库存，将产品出库。

4、产品调拨
输入产品编号、数量，根据产品编号和数量查询满足条件的库存，选择库存，再查询可以存放产品的库存，进行产品调拨。
## 库存预警
存量预警
在库存操作中要监控库存容量，如果超出限制，给出提示，没有超出限制则不做任何操作。

# 运行指南
1.创建数据库waremanager，运行sql文件夹下的sql文件
2.修改util/DBHelper里的数据库连接信息，username和password修改为自己的
