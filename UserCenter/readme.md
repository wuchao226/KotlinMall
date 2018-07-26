两套Manifest
1，一套用于Application时使用，配置主题及默认启动，位于debug目录
2，一套用于Library时使用，注册组件及权限，位于release目录

Manifest 切换，在build.gradle中的android 目录下添加如下代码
```
 sourceSets {
        main {
            if (isUserModule.toBoolean()) {
                manifest.srcFile 'src/main/release/AndroidManifest.xml'
                //release模式下排除debug文件夹下所有的Java文件
                java {
                    exclude 'debug/**'
                }
            } else {
                manifest.srcFile 'src/main/debug/AndroidManifest.xml'
            }
        }
    }
  ```
