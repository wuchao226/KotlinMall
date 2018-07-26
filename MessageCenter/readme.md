1、主工程build.gradle需要配置JPUSH_PKGNAME:applicationId，否则Manifest找不到访key
2、其它配置放到message中
3、使用gradle自动引包，不需要其它配置
4、自定义Recevier加项目配置。
5、主工程进行初始化