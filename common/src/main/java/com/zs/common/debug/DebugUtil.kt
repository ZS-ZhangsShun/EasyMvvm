package com.zs.common.debug

object DebugUtil {
    var isDebug: Boolean = true
    var channelsJson: String = "{\"showapi_res_error\": \"\",\n" +
            "  \"showapi_res_id\": \"626e42e80de376a006be0ebb\",\n" +
            "  \"showapi_res_code\": 0,\n" +
            "  \"showapi_fee_num\": 1,\n" +
            "  \"showapi_res_body\": {\n" +
            "        \"totalNum\":49,\n" +
            "        \"channelList\":[\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001cd\",\"name\":\"国内焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001ce\",\"name\":\"国际焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001cf\",\"name\":\"军事焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d0\",\"name\":\"财经焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d1\",\"name\":\"互联网焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d2\",\"name\":\"房产焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d3\",\"name\":\"汽车焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d4\",\"name\":\"体育焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d5\",\"name\":\"娱乐焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d6\",\"name\":\"游戏焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d7\",\"name\":\"教育焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d8\",\"name\":\"女人焦点\"},\n" +
            "            {\"channelId\":\"5572a108b3cdc86cf39001d9\",\"name\":\"科技焦点\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001da\",\"name\":\"社会焦点\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001db\",\"name\":\"国内最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001dc\",\"name\":\"台湾最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001dd\",\"name\":\"港澳最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001de\",\"name\":\"国际最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001df\",\"name\":\"军事最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e0\",\"name\":\"财经最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e1\",\"name\":\"理财最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e2\",\"name\":\"宏观经济最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e3\",\"name\":\"互联网最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e4\",\"name\":\"房产最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e5\",\"name\":\"汽车最新\"},\n" +
            "            {\"channelId\":\"5572a109b3cdc86cf39001e6\",\"name\":\"体育最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001e7\",\"name\":\"国际足球最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001e8\",\"name\":\"国内足球最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001e9\",\"name\":\"CBA最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001ea\",\"name\":\"综合体育最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001eb\",\"name\":\"娱乐最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001ed\",\"name\":\"电影最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001ee\",\"name\":\"游戏最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001ef\",\"name\":\"教育最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001f0\",\"name\":\"女人最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001f1\",\"name\":\"美容护肤最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001f2\",\"name\":\"情感两性最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001f3\",\"name\":\"健康养生最新\"},\n" +
            "            {\"channelId\":\"5572a10ab3cdc86cf39001f4\",\"name\":\"科技最新\"},\n" +
            "            {\"channelId\":\"5572a10bb3cdc86cf39001f5\",\"name\":\"数码最新\"},\n" +
            "            {\"channelId\":\"5572a10bb3cdc86cf39001f6\",\"name\":\"电脑最新\"},\n" +
            "            {\"channelId\":\"5572a10bb3cdc86cf39001f7\",\"name\":\"科普最新\"},\n" +
            "            {\"channelId\":\"5572a10bb3cdc86cf39001f8\",\"name\":\"社会最新\"},\n" +
            "            {\"channelId\":\"57463656a44a13cf\",\"name\":\"旅游最新\"},\n" +
            "            {\"channelId\":\"61b6c4326de57a0ac09d7e08\",\"name\":\"家政最新\"},\n" +
            "            {\"channelId\":\"61b6c3e26de57a0ac09d7e07\",\"name\":\"育儿最新\"},\n" +
            "            {\"channelId\":\"9a15d3d4b5cab17f34e6d7976b1b1f30\",\"name\":\"电商最新\"},\n" +
            "            {\"channelId\":\"5b4fe11ec1239b0805568da6e90fd875\",\"name\":\"物流最新\"},\n" +
            "            {\"channelId\":\"3f4794412eaa17ed\",\"name\":\"创业最新\"}\n" +
            "        ],\n" +
            "  \"ret_code\":0\n" +
            "  }\n" +
            "}"
    var guoJiNewsJson: String = "{\n" +
            "                  \"showapi_res_error\": \"\",\n" +
            "                  \"showapi_res_id\": \"626e79e70de3769e0660d243\",\n" +
            "                  \"showapi_res_code\": 0,\n" +
            "                  \"showapi_fee_num\": 1,\n" +
            "                  \"showapi_res_body\": {\"pagebean\":{\"allNum\":26129,\"contentlist\":[{\"link\":\"https://www.chinanews.com.cn/cj/2022/05-01/9744529.shtml\",\"pubDate\":\"2022-05-01 19:25:19\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/0c13a9252a4b446ebb5392b4c0a16d26.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/0c13a9252a4b446ebb5392b4c0a16d26.jpg\",\"havePic\":true,\"id\":\"4010458c8ff69251cd50bd876e52c102\",\"channelName\":\"国际焦点\",\"title\":\"巴菲特：“华尔街就是个赌场”“通胀打劫了所有人”\",\"desc\":\"　　中新财经5月1日电(石睿) 当地时间4月30日，一年一度的“投资界的春晚”——巴菲特股东大会在奥马哈召开，这也是新冠疫情暴发之后，91岁的“股神”沃伦·巴菲特与98岁的老搭档查理·芒格时隔两年再次与投资者在线下见面。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/gn/2022/05-01/9744463.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"金星木星“五一”假期“结伴游” 上演“亲密一刻”\",\"pubDate\":\"2022-05-01 18:15:35\",\"desc\":\"　　中新网南京5月1日电 (记者 杨颜慈)据中国科学院紫金山天文台1日消息，在5月的第1天，天宇迎来了重磅天象——金星和木星在黎明的天空中越走越近，达到“最亲密一刻”，两颗行星几乎挨在了一起。因金星木星“结伴游”出现在“五一”的清晨，特别适合因疫情宅家的民众体验“星空游”。\",\"id\":\"9467295e2bfe683469d14bdc570cd792\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/05-01/9744467.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"上海宝山区3名干部因发放保供物资失职失责被处理\",\"pubDate\":\"2022-05-01 18:09:00\",\"desc\":\"　　中新网5月1日电 据廉洁上海微信公众号消息，上海市宝山区张庙街道党工委书记施永根、张庙街道泗塘二村振兴居委会书记周东红、主任倪传悦在负责发放政府保供物资和兄弟省捐赠的食品礼包过程中，组织不力、作风拖沓，对部分物资未及时发放导致腐烂浪费问题负有责任，造成严重不良影响。施永根、周东红、倪传悦3人均被免职，并接受进一步调查。\",\"id\":\"0508e8113f7f7dc276903a11dd56b1b0\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/05-01/9744375.shtml\",\"pubDate\":\"2022-05-01 15:33:30\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/75002e14308a407b8dc4ea2c37882d9d.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/75002e14308a407b8dc4ea2c37882d9d.jpg\",\"havePic\":true,\"id\":\"eda727bd1f5b08e471bbd61cba4dacb5\",\"channelName\":\"国际焦点\",\"title\":\"上海警方：一外卖骑手核酸结果异常仍外出被立案侦查\",\"desc\":\"　　中新网5月1日电 上海市公安局官方微博5月1日发布通报称，5月1日，上海杨浦警方查获一名核酸检测结果异常、无电子通行证的外卖骑手，该骑手因涉嫌妨害传染病防治罪被依法立案侦查。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/dwq/2022/05-01/9744333.shtml\",\"pubDate\":\"2022-05-01 14:25:19\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/e01fbe8c-b6bc-45e6-994b-f353900b4da6_zsite.JPG\",\"height\":0,\"width\":0},{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/ab69c687-d289-4160-be63-8c1ed41623b6_zsite.JPG\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/e01fbe8c-b6bc-45e6-994b-f353900b4da6_zsite.JPG\",\"havePic\":true,\"id\":\"c12ad4e29d444d1c11e18104fdfcb912\",\"channelName\":\"国际焦点\",\"title\":\"两万多名援港劳动者 用“速度”守护美丽香江\",\"desc\":\"　　(情满大湾区)两万多名援港劳动者 用“速度”守护美丽香江\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/05-01/9744326.shtml\",\"pubDate\":\"2022-05-01 14:21:51\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/f573a37a-7c3a-45dd-b44e-cb842f48b300_zsite.jpg\",\"height\":0,\"width\":0},{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/d29cbf00-1ee7-4e82-83c7-1b4ffbf320f0_zsite.jpg\",\"height\":0,\"width\":0},{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/0bc3bda9-457a-4808-af8d-90d443255330_zsite.jpg\",\"height\":0,\"width\":0},{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/07cc83a1-0327-4420-b90a-94a2c4ab74e2_zsite.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/f573a37a-7c3a-45dd-b44e-cb842f48b300_zsite.jpg\",\"havePic\":true,\"id\":\"07d742ea4df14b175741b05975a9e3be\",\"channelName\":\"国际焦点\",\"title\":\"河南一高校学生组队钓鱼 3200斤全鱼宴免费吃\",\"desc\":\"　　中新网郑州5月1日电(记者 韩章云)“五一”假期怎么过？校园垂钓享渔翁之乐可好？4月29日，郑州航空工业管理学院举办的校园垂钓活动上演如此欢乐的一幕，邀请全校学生钓鱼、吃鱼过假期。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/05-01/9744302.shtml\",\"pubDate\":\"2022-05-01 13:58:17\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/f0d147ec-5ba9-4187-ad1a-3f03415fcc37_zsite.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/ypt/2022/220501/f0d147ec-5ba9-4187-ad1a-3f03415fcc37_zsite.jpg\",\"havePic\":true,\"id\":\"c2a2b175ac7781f3ee6af48ec9e41205\",\"channelName\":\"国际焦点\",\"title\":\"黑龙江黑河：江边现迫击炮弹 民警迅速排除险情\",\"desc\":\"　　中新网黑河5月1日电(韩飞 记者姜辉)1日，黑龙江出入境边防检查总站黑河边境管理支队山湖边境派出所接到报警，黑龙江江边发现一枚炮弹。民警立即赶往现场，初步鉴定是一枚弹体完整的迫击炮弹。目前，险情已排除。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/05-01/9744281.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"湖南长沙警方通报居民自建房倒塌事故：9人被刑拘\",\"pubDate\":\"2022-05-01 13:24:21\",\"desc\":\"　　中新网5月1日电 4月29日12时24分，湖南长沙市望城区金山桥街道金坪社区一居民自建房发生倒塌事故。今日(5月1日)，长沙市公安局官方微博“长沙警事”发布警情通报。\",\"id\":\"718436c3175db969befd293e356f6907\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/05-01/9744185.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"俄将参加《不扩散核武器条约》实施情况审议大会\",\"pubDate\":\"2022-05-01 11:24:36\",\"desc\":\"　　中新网5月1日电 据塔斯社报道，当地时间4月30日，俄罗斯外交部防扩散与军备控制司司长叶尔马科夫表示，俄罗斯已开始筹备参加将于8月1日至26日在美国纽约举行的第十次《不扩散核武器条约》(NPT)实施情况审议大会。\",\"id\":\"a63452690fd66c067acfa77e9da530dd\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/05-01/9744143.shtml\",\"pubDate\":\"2022-05-01 10:01:58\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/a151e49e699544d7a731082adf520b26.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/a151e49e699544d7a731082adf520b26.jpg\",\"havePic\":true,\"id\":\"527554c662ebee01436d6543dc57f4a5\",\"channelName\":\"国际焦点\",\"title\":\"美国会骚乱调查：特朗普法律顾问将提交1万页文件\",\"desc\":\"　　中新网5月1日电 据美国政治新闻网站Politico报道，当地时间4月29日，美国前总统特朗普的法律顾问约翰·伊斯曼(John Eastman)的律师表示，伊斯曼将向负责调查2021年1月6日美国国会大厦骚乱事件的众议院特别委员会提交1万多页材料。此外，伊斯曼仍对约27000页文件主张享有律师-当事人保密特权。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/cul/2022/05-01/9744096.shtml\",\"pubDate\":\"2022-05-01 08:44:25\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/124662b85c094878a746131feebefe37.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/05/01/124662b85c094878a746131feebefe37.jpg\",\"havePic\":true,\"id\":\"74ba7b95bbbaececfee1a59b067e1ede\",\"channelName\":\"国际焦点\",\"title\":\"与古人一起过劳动节：若穿越回古代你能从事什么职业？\",\"desc\":\"　　勤劳，是深深烙印在中国人DNA里的一种美德。“五一”国际劳动节，享受假期的你知道古代咱们的先人是怎么劳动的吗？让我们穿越进流传千古的经典名画里，跟着古人一起过个劳动节，体验中国人传承不变的勤劳与奋进。思考题：真穿越回古代的话，你能从事什么职业？↓↓↓\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/05-01/9744037.shtml\",\"pubDate\":\"2022-05-01 00:08:37\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/95b2b7e3c498426eb10fa7c0cc56a2a8.jpg\",\"height\":0,\"width\":0},{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/ea944a79adbd42a1bc7b195fe532bdd7.jpg\",\"height\":0,\"width\":0},{\"url\":\"http://image1.chinanews.com.cn/cnsupload/big/2020/12-15/4-561/09fab4e44a5f4101a2c839ee7787fb4a.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/95b2b7e3c498426eb10fa7c0cc56a2a8.jpg\",\"havePic\":true,\"id\":\"688551f2f858e0001bd8ca3889170ac9\",\"channelName\":\"国际焦点\",\"title\":\"卢布结算令生效满月，欧洲国家要“断气”了\",\"desc\":\"　　中新网北京5月1日电(管娜)5月1日，距离俄罗斯要求“不友好”国家和地区的客户用卢布购买天然气的法令生效满月。仅仅30天，欧洲国家就已陷入两难境地，水涨船高的能源价格，令民众苦不堪言，进而引发社会动荡。美国则开拓了市场，成为这场能源“战争”的唯一受益者。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/04-30/9743996.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"律师：劳荣枝案二审因不可抗拒原因中止审理\",\"pubDate\":\"2022-04-30 21:04:41\",\"desc\":\"　　4月30日，澎湃新闻(www.thepaper.cn)从劳荣枝辩护律师吴丹红处获悉，昨日\",\"id\":\"ae1968c83f4c9190d85b1dfbf1e1e850\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/04-30/9743963.shtml\",\"pubDate\":\"2022-04-30 21:01:02\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://image1.chinanews.com.cn/cnsupload/big/2022/04-25/4-426/bda17f8a4921446aad0ff636c50c9365.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://image1.chinanews.com.cn/cnsupload/big/2022/04-25/4-426/bda17f8a4921446aad0ff636c50c9365.jpg\",\"havePic\":true,\"id\":\"00dff6b7e1f87a8d5d51574428ddef37\",\"channelName\":\"国际焦点\",\"title\":\"法乌首脑通电话：法国将加强对乌克兰的军事援助\",\"desc\":\"　　中新网4月30日电 综合报道，当地时间30日，法国总统马克龙和乌克兰总统泽连斯基进行了电话会谈。消息人士表示，在此次通话中，马克龙表示，将会加强对乌克兰的军事和人道主义援助。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/04-30/9743872.shtml\",\"pubDate\":\"2022-04-30 21:00:06\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/850d28e5038242e8a2a3406ecaba9945.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/850d28e5038242e8a2a3406ecaba9945.jpg\",\"havePic\":true,\"id\":\"eae7fb1e806273438534e2c3c9fe6a86\",\"channelName\":\"国际焦点\",\"title\":\"俄航天公司：已就退出国际空间站项目时间做出决定\",\"desc\":\"　　中新网4月30日电 据俄罗斯卫星通讯社报道，当地时间30日，俄罗斯国家航天公司总裁罗戈津表示，已就退出国际空间站项目的日期做出决定，相关提议已提交至俄罗斯政府和俄总统普京。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/04-30/9743879.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"德国财长：德国拒绝以卢布支付俄罗斯天然气\",\"pubDate\":\"2022-04-30 19:15:36\",\"desc\":\"　　德国财政部长林德纳30日在社交媒体上表示，德国拒绝使用卢布支付俄罗斯天然气，并且未来也没有这样做的计划。\",\"id\":\"50f4d15365737f0cc75eb533a2dd355d\"},{\"link\":\"https://www.chinanews.com.cn/gj/2022/04-30/9743830.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"英国不明病因儿童肝炎病已达145例 多人移植肝脏\",\"pubDate\":\"2022-04-30 17:52:40\",\"desc\":\"　　中新网4月30日电 综合外媒报道，当地时间29日，英国卫生安全局表示，自25日以来，英国新增34例在儿童群体中发生的不明病因肝炎病例，累计病例数达到145例。\",\"id\":\"4c9421f02e0175bb3295c39e38a8d333\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/04-30/9743832.shtml\",\"pubDate\":\"2022-04-30 17:46:04\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/0318052a57f3466e96e0911f71ce7cec.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/0318052a57f3466e96e0911f71ce7cec.jpg\",\"havePic\":true,\"id\":\"1e62bd657cc53305a0b5a6bf52e293c3\",\"channelName\":\"国际焦点\",\"title\":\"【挑战365天正能量速写画】第151期：令人感动的缺课\",\"desc\":\"　　近日，长春医学高等专科学校2021级临床医学专业“乡村医生班”在线学习率较低，却引起全校师生自豪与感动。疫情来袭，2021年录取的1134名村医中，超一半学生加入抗疫一线。学生称，每次看到居民采样结果是阴性时，觉得再累也值了。 为有责任有担当的大学生点赞！\",\"channelId\":\"5572a108b3cdc86cf39001ce\"},{\"link\":\"https://www.chinanews.com.cn/sh/2022/04-30/9743673.shtml\",\"source\":\"中国新闻网\",\"imageurls\":[],\"havePic\":false,\"channelId\":\"5572a108b3cdc86cf39001ce\",\"channelName\":\"国际焦点\",\"title\":\"河北三河累计发生2例阳性病例 当地调整管控措施\",\"pubDate\":\"2022-04-30 13:53:54\",\"desc\":\"　　中新网4月30日电 据“网信三河”微信公众号消息，河北三河市应对新型冠状病毒感染的肺炎疫情防控工作领导小组办公室30日发布通告称，4月27日以来，三河市已累计发生2例阳性病例，北京新通报阳性病例行动轨迹涉及三河市多个点位，三河市在执行静止管理前，大量通勤人员来返三河，疫情形势异常严峻。经三河市应对新冠疫情工作领导小组研究，决定对三河市管控措施进行如下调整：\",\"id\":\"1683771674565c383454c8a1087539d2\"},{\"link\":\"https://www.chinanews.com.cn/gn/2022/04-30/9743640.shtml\",\"pubDate\":\"2022-04-30 12:07:28\",\"source\":\"中国新闻网\",\"imageurls\":[{\"url\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/a1b39bc5b10a4986afd2e18b91503e8c.jpg\",\"height\":0,\"width\":0}],\"img\":\"http://i2.chinanews.com.cn/simg/cmshd/2022/04/30/a1b39bc5b10a4986afd2e18b91503e8c.jpg\",\"havePic\":true,\"id\":\"df60beb5932a3fa6103cb191431a36d6\",\"channelName\":\"国际焦点\",\"title\":\"长十一火箭圆满完成“一箭五星”海上发射任务\",\"desc\":\"　　中新网北京4月30日电 (马帅莎 喻鹏 郝明鑫)北京时间4月30日11时30分，中国在东海海域使用长征十一号海射遥三火箭发射吉林一号高分03D(04～07)/04A卫星，卫星顺利进入预定轨道，发射任务获得圆满成功。该卫星主要为国土资源普查、城市规划、灾害监测等行业领域提供商业遥感服务。\",\"channelId\":\"5572a108b3cdc86cf39001ce\"}],\"maxResult\":20,\"currentPage\":1,\"allPages\":1307},\"ret_code\":0}\n" +
            "\n" +
            "                }"

    fun getNewsList(id: String?): String {
        //除了第一个国内焦点新闻 其他都用这个 提高速度 仅仅是用作演示
        if (id != "5572a108b3cdc86cf39001cd") {
            return guoJiNewsJson
        } else {
            return ""
        }
    }
}