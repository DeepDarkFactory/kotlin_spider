<p align="center"><a href="https://github.com/DeepDarkFactory" target="_blank"><img width="100"src="http://7xqvgr.com1.z0.glb.clouddn.com/logo.jpg"></a></p>

<p align="center">
  <a href="https://github.com/DeepDarkFactory"><img src="https://img.shields.io/badge/Made%20in-DDF-ff69b4.svg" /></a>
  <a href="https://gradle.org/"><img src="https://img.shields.io/badge/gradle-3.5-brightgreen.svg" /></a>
  <a href="https://gradle.org/"><img src="https://img.shields.io/badge/gradle-3.5-brightgreen.svg" /></a>
  <a href="https://github.com/Nbsaw/kotlin_spider/blob/master/LICENSE"><img src="https://img.shields.io/npm/l/vue.svg" alt="License"></a>
</p>

## 简介
目标是拿Kotlin写各种有趣的爬虫。然后用Javascript做各种效果。

## 目前想做的爬虫
- [X] 网易歌词爬虫
- [ ] 微博爬虫
- [ ] QQ爬虫
- [ ] 知乎日报

## 各个爬虫的详细功能
这里目前只说已经做完的爬虫。

### 网易歌词爬虫
这是一个爬取歌词然后进行分析的小程序。根据歌手的名字找到歌手的id,在通过歌手的id查找歌手top50的歌曲,然后获取歌词并过滤掉一些不需要的信息。找出最常使用的那些词组存到数据库里做缓存。找出词组使用了[结巴分词](https://mvnrepository.com/artifact/com.huaban/jieba-analysis/1.0.2)当查询歌手的时候,先判断数据库有没有这个歌手的记录,如果有直接从数据库中查找歌词列表,如果没有,在线爬取。前端使用了[d3-cloud](https://github.com/jasondavies/d3-cloud)生成词云。主要想生成的词云样子如下:
<p><img src="http://7xqvgr.com1.z0.glb.clouddn.com/%E8%96%9B%E4%B9%8B%E8%B0%A6%E8%AF%8D%E4%BA%91" width="600px" alt="是的就是薛之谦 :D" /></p>

## 为什么使用Kotlin做为后端语言
主要有以下方面
1. 我在学习这门语言
2. 我喜欢这门语言
3. 这门语言是一门不错的语言,有些地方可以写的很短
4. 因为我是java开发者,完全兼容java,所以我用着还行

## 关于DDF
我们是Deep Dark Factory(念起来很羞耻)一个有意思的小团队,目前写后端代码的人是我,写前端的是我的小伙伴[@Hazlank](https://github.com/Hazlank),如果你有更好的建议或者想法欢迎你提交到issuse里面一起讨论,或者加入我们的团队。我们随时欢迎新成员,不管你是写Kotlin,Java,Node或是其他的都不重要,重要的是你能来。

## License
[The MIT License (MIT)](https://github.com/Nbsaw/kotlin_spider/blob/master/LICENSE)
