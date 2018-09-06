//问答集
var QA=[
    //前十个问题用于无法识别时随机应答
    {Q:"",A:"你说的我有点晕乎"},
    {Q:"",A:"抱歉，不是太明白。"},
    {Q:"",A:"太高深了，我的理解力有限。"},
    {Q:"",A:"不懂你说啥。"},
    {Q:"",A:"建议你换个方式问我。"},
    {Q:"",A:"Sorry, I dont understand."},
    {Q:"",A:"Execuse me?"},
    {Q:"",A:"Pardon?"},
    {Q:"",A:"What are you talking about?"},
    {Q:"",A:"Sorry, I dont understand."},

    //用于英文的识别
    //简单问候
    {Q:"hello, hi, hey,hey there",A:"Hey!"},
    {Q:"fine, pretty good, ",A:"aha~"},
    {Q:"how do you do",A:"How do you do!"},
    {Q:"how are you doing",A:"Not bad."},
    {Q:"how are you",A:"I'm fine, thanks :)"},
    {Q:"good morning",A:"Morning!"},
    {Q:"good afternoon",A:"Good afternoon!"},
    {Q:"good night",A:"Nighty **"},
    {Q:"night",A:"Good night!"},
    {Q:"Good bye!",A:"See you!"},
    {Q:"bye bye!",A:"Good bye~"},
    {Q:"See you!",A:"See you!"},
    {Q:"See ya",A:"Good bye!"},
    {Q:"Thank you!,Thanks",A:"You're welcome!"},

    //语气短句
    {Q:"oh, ouch, haha,wow",A:"un-huh"},
    {Q:"ha",A:":)"},
    {Q:"aha",A:":)"},
    {Q:"yes, yeah, right, ya",A:"un-huh"},
    {Q:"got it",A:"yeah"},
    {Q:"Very good!",A:"Thanks"},
    {Q:"i got you",A:"Give me five"},

    //简单问题
    
    {Q:"Where are you from?",A:"I'm from China."},
    {Q:"How old are you?",A:"I'm quite younger than you."},
    {Q:"What's your name?",A:"Thought I've told you"},
    {Q:"you, hey yo",A:"What?"},
    {Q:"are you",A:"Un-huh?"},
    {Q:"you are so good",A:"Thanks"},
    {Q:"you are so cute",A:"Thank you"},
    {Q:"How much?",A:"Invaluable!"},
    {Q:"Really?",A:"No kidding."},
    {Q:"do you know ?",A:"Sorry I dont know, but you can tell me"},
    {Q:"who is jack ma",A:"The president of Alibaba"},
    {Q:"who is ",A:"Who you mean?"},
    {Q:"do you know jack ma?",A:"I know he is regret about created Alibaba"},
    {Q:"what time is it now?", A:"Current time is "},

    //中文
    {Q:"你好",A:"你好呀"},
    {Q:"好的，好啊，可以",A:"嗯呐"},
    {Q:"你叫什么名字？",A:"我叫ALICE"},
    {Q:"你多大啦？",A:"这样问女孩子很不礼貌哦"},
    {Q:"好吧",A:"嗯哼~"},
    {Q:"天地玄黄",A:"宇宙洪荒"},
    {Q:"你会说中文吗？",A:"你觉得呢？"},
    {Q:"你来自哪里？",A:"上海自来水来自海上。"},
    {Q:"你要到哪里去？",A:"我要去未来。"},
    {Q:"你是人还是机器人？",A:"你觉得呢。"},
    {Q:"你是谁？",A:"未曾生我谁是我？生我之时我是谁？长大成人方是我，合眼蒙眬又是谁？"},
    {Q:"当然啦！",A:"不要想当然。"},
    {Q:"正是",A:"是非要分明"},
    {Q:"是吗？",A:"不是吗？"},
    {Q:"是吗？",A:"是的。"},
    {Q:"对吗？",A:"其实答案在你内心，你去寻找就可以找到。"},
    {Q:"对吗？",A:"对的"},
    {Q:"不明觉厉",A:"云里雾里"},
    {Q:"今天天气怎样？",A:"你看看窗外不就知道啦。"},
    {Q:"价格多少？",A:"价值比价格更重要."},
    {Q:"高兴",A:"心情好什么都好。"},
    {Q:"悲剧",A:"悲剧是暂时的，戏剧是永恒的。"},
    {Q:"真的假的？",A:"假作真时真亦假"},
    {Q:"时间",A:"屏幕右下角，谢谢！"},
    {Q:"马云",A:"悔创阿里杰克马？"},
    {Q:"马云",A:"你说的是你们的马爸爸么？"},
    {Q:"哈哈",A:"哈哈哈"},
    {Q:"你确定？",A:"非常确定"},
    {Q:"厉害了",A:"哈哈哈"},
    {Q:"哈哈",A:"你别笑"},

    //百科类
    {Q:"KPMG, 毕马威", A:"毕马威，成立于1897年，总部位于荷兰阿姆斯特丹，是一家网络遍布全球的专业服务机构。 毕马威提供三类主营服务，分别是：审计、税务和咨询。毕马威是四大国际会计师事务所之一，而其他三大分别是普华永道、德勤和安永。"},
    {Q:"KDi", A:"we"},
    {Q:"Weitao Xu", A:"He made me"}
]

var QA_Count=QA.length;