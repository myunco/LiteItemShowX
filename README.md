# LiteItemShowX
这是一款轻量级的物品展示插件，让玩家可以在聊天时展示手中的物品。
### 插件介绍
使用方法非常简单：只需将要展示的物品拿在主手，然后在聊天里输入'物品展示关键字(默认是[i])'  
对于没有改过名字的物品，展示的名字是根据玩家客户端选择的语言来决定的。例如手拿石头发送[i]，简体中文客户端显示[石头]，而英文客户端显示[Stone]  
注意：虽然发送后的消息看起来像是玩家直接发送的，但实际上是插件获取聊天格式后"伪造"出来的消息，所以可能会与某些修改聊天格式的插件不兼容。但通常这些聊天插件自带物品展示功能，删除本插件即可

### 本插件与LiteItemShow的区别：<br>
1. 本插件只支持Paper系服务端，不支持Bukkit和Spigot<br>
2. 本插件不支持展示物品时含有其他文字，例如不支持发送 "看看我的[i]"，只有发送的消息和关键词完全匹配才能展示物品。<br>
3. 本插件支持自定义括号颜色、显示物品数量<br>
4. 本插件基于1.21开发，不再兼容低版本Minecraft<br>

以下是默认的配置：
```YML
#显示手持物品的关键字
keyword: '[i]'
#是否显示物品数量 true=显示 false=不显示
showAmount: true
#括号颜色 RGB格式
sColor: '55FFFF'
#物品数量 x 颜色 RGB格式 ([石头 x64]的x)
xColor: 'FFAA00'
#物品数量 数字颜色 RGB格式 ([石头 x64]的64)
nColor: 'FFAA00'
```
### 插件截图
![image](https://github.com/user-attachments/assets/7bce4dec-f4fe-4464-9850-56a37d85a10c)
### 命令/权限
命令：  
- /LiteItemShowX reload —— 重载插件配置   
- /LiteItemShowX version —— 查看插件版本  
- 以上/LiteItemShowX 可以缩写为/lis 或/lisx

权限：  
- LiteItemShowX.admin —— 权限 可使用/LiteItemShowX命令，默认OP拥有  
- LiteItemShowX.show —— 权限 可在聊天中展示物品，默认所有玩家拥有  

bStats
---
[![bStats Graph Data](https://bstats.org/signatures/bukkit/LiteItemShow.svg)](https://bstats.org/plugin/bukkit/LiteItemShow)

下载
---
你可以在以下位置下载官方版本:
- **Github**: https://github.com/myunco/LiteItemShowX/releases

如何安装？
---
* 下载最新版本插件。
* 将 LiteItemShow-0.x.x.jar 文件放入 plugins 文件夹中。
* 启动服务器。 (仅支持Paper及衍生服务端)
* 现在插件应该在 /plugins 命令中显示为绿色。 如果显示红色或不存在，请检查控制台日志的错误信息。

环境需求
---
* Java 21+
* Paper 1.20+

# 鸣谢
感谢 [JetBrains](https://www.jetbrains.com/?from=ServerMonitor) 提供的 [Free Open Source Licenses](https://jb.gg/OpenSourceSupport)

[![JetBrains Logo (Main) logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.svg)](https://www.jetbrains.com/?from=ServerMonitor)
