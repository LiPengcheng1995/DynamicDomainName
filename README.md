# DynamicDomainName
学习，springboot+mybatis+sqlite,了解sqlite数据库，仿制switchhosts


#增加云端的类似备份的东西
程序接口设计：
	实现功能：修改域名映射ip
		1. 增加映射
		2. 开关关闭映射
		3. 关闭程序后删除所有映射
		4. 有按钮，可启用license server本地服务
		5. 退出后保存记录到嵌入式数据库，然后清楚痕迹

	接口：
		1. 获得所有配置好的映射【配置过的映射】  GET  /api/mapping/getAll
		2. 点击开关，启用、关闭映射 
			2.1 启用映射  POST  /api/mapping/activation/{id}
			2.2 关闭映射  POST  /api/mapping/inactivation/{id}
		3. 保存新映射：输入注释【可空】、ip【不可空】、域名【不可空】  POST /api/mapping/add
		4. 删除映射，选择，然后删除。 DELETE /api/mapping/delete 
		4. 启用、关闭本地license server服务 
			4.1 获得license server服务列表  GET /api/licenserServer/getAll
			4.1 启用license server服务  POST  /api/licenseServer/{ServerId}/activation
			4.2 关闭license server服务  POST  /api/licenseServer/{ServerId}/inactivation

		




把Java转化为Windows可运行程序
http://blog.csdn.net/JohnnydotJi/article/details/54382706





反向代理开发：
https://www.tianmaying.com/tutorial/http-proxy

switchhosts 模仿demo可以加东西。加登录的东西，把它在线链接到线上的MySQL数据库。【自己写一个服务端吧，别直接连了，有风险】


