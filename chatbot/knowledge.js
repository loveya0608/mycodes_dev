//问答集
var QA=[
    //无法识别时，回答
    {
        Q:  "",
        A:[ "你说的我有点晕乎",
            "抱歉，不是太明白。",
            "太高深了，我的理解力有限。",
            "不懂你说啥。",
            "建议你换个方式问我。",
            "Sorry, I dont understand.",
            "Execuse me?",
            "Pardon?",
            "What are you talking about?",
            "Sorry, I dont understand."
        ]
    },
    //简单问候
    {
        Q:"hi,hey,hello,hey there,hey yo",
        A:[ "Hey!",
            'Hi~',
            'Hello',
            'Hi there',
            'Un-huh',
            "What's up?"
        ]
    },
    {
        Q:"how do you do,how are you doing",
        A:[ "How do you do!",
            'Not bad~',
            "I'm fine, thanks :)",
            'Hi there',
            'Un-huh',
            "What's up?"
        ]
    },
    {
        Q:"fine,pretty good",
        A:[ "~",
            'Au-hun~'
        ]
    },
    {
        Q:"good morning",
        A:[
            "Morning!",
            'Good morning'
        ]
    },
    {
        Q:"good afternoon",
        A:["Good afternoon!"]
    },
    {
        Q:"good night",
        A:[
            "Nighty night*",
            "Good night!",
            "Good dream 🌙"
        ]
    },
    {
        Q:"Good bye,bye,see you,see ya",
        A:[
            "See you!",
            'Good bye~',
            'Bye~',
            'See ya'
        ]
    },
    {
        Q:"thank you,thanks",
        A:[
            "You're welcome!",
            'Never mind'
        ]
    },

    //语气短句
    {
        Q:"oh,ouch,haha,wow,aha",
        A:[
            "Un-huh",
            'Hah',
            'Yeah',
            ':)'
        ]
    },
    {
        Q:"yes,yeah,right,ya",
        A:[
            "un-huh",
            ':)'
        ]
    },
    {
        Q:"got it,good",
        A:[
            "Nice",
            'Good',
            'Okay'
        ]
    },
    {
        Q:"Very good!",
        A:[
            "Thanks"
        ]
    },

    //简单问题
    {
        Q:"Where are you from?",
        A:[
            "I'm from China.",
            "I'm from Internet"
        ]
    },
    {
        Q:"How old are you?",
        A:[
            "I'm quite younger than you.",
            "I'm a baby",
            "How old are you?"
        ]
    },
    {
        Q:"What's' your name",
        A:[
            "Thought I've told you",
            "I'm Alice",
            "My name is Alice"
        ]
    },
    {
        Q:"who are you",
        A:[
            "Thought I've told you",
            "I'm Alice",
            "My name is Alice"
        ]
    },
    {
        Q:"you are so good,you are so cute",
        A:["Thanks"]
    },
    {
        Q:"How much?",
        A:[
            "Invaluable!",
            "The shirt's price is 9.15￡"
        ]
    },
    {
        Q:"Really?",
        A:[
            "No kidding.",
            "Yes",
            "Yeah~"
        ]
    },
    {
        Q:"do you know?",
        A:[
            "Sorry I dont know, but you can tell me",
            "Teach me"
        ]
    },
    {
        Q:"jack ma",
        A:[
            "The president of Alibaba",
            "The man who is regret about created Alibaba",
            "Ali Baba"
        ]
    },
    {
        Q:"who is",
        A:[
            "Who you mean?"
        ]
    },
    {
        Q:"time now", 
        A:[
            "CURRENTTIME"
        ]
    },

    {
        Q:"search,google,baidu", 
        A:[
            "SEARCH"
        ]
    },

    //中文
    //简单问候
    {
        Q:"你好",
        A:[
            "你好呀",
            '你好'
        ]
    },
    {
        Q:"早上好",
        A:[
            "早~",
            '早安',
            '早上好'
        ]
    },
    {
        Q:"中午好",
        A:[
            "中午好",
            '午安'
        ]
    },
    {
        Q:"晚上好",
        A:[
            "晚上好",
            '晚安'
        ]
    },
    {
        Q:"吃了吗",
        A:[
            "还没呢",
            '我不用吃饭',
            '想吃什么？'
        ]
    },
    {
        Q:"好的，好啊，可以",
        A:[
            "嗯呐",
            '好的',
            '奈斯'
        ]
    },
    {
        Q:"你叫什么名字？",
        A:[
            "我叫ALICE",
            '我好像告诉过你',
            '不告诉你'
        ]
    },
    {
        Q:"你多大啦？",
        A:[
            "女孩子的秘密",
            '我才出生没多久',
            '我还是个宝宝',
            '比你年轻多啦'
        ]
    },
    {
        Q:"好吧",
        A:[
            "嗯哼~"
        ]
    },
    {
        Q:"你会说中文吗？",
        A:[
            "你觉得呢？",
            '不会',
            '你猜'
        ]
    },
    {
        Q:"你来自哪里？",
        A:[
            "上海自来水来自海上。",
            '我从哪里来？'
        ]
    },
    {
        Q:"你是人还是机器人？",
        A:[
            "你觉得呢。",
            '干嘛问这个？',
            'So?'
        ]
    },
    {
        Q:"你是谁？",
        A:[
            '好问题',
            '你想知道我的名字？'
        ]
    },
    {
        Q:"当然啦！",
        A:[
            "不要想当然。"
        ]
    },
    {
        Q:"是吗？"
        ,A:[
            "不是吗？",
            '是的',
            '不然呢'
        ]
    },
    {
        Q:"对吗？",
        A:[
            "其实答案在你内心，你去寻找就可以找到。",
            '对的',
            '是的'
        ]
    },
    {
        Q:"不明觉厉",
        A:[
            "云里雾里"
        ]
    },
    {
        Q:"今天天气怎样？",
        A:[
            "你看看窗外不就知道啦。",
            '我觉得不错'
        ]
    },
    {
        Q:"价格多少？",
        A:[
            "价值比价格更重要."
        ]
    },
    {
        Q:"高兴",
        A:[
            "心情好什么都好。"
        ]
    },
    {
        Q:"现在几点",
        A:[
            "屏幕右下角，谢谢！",
            'CURRENTTIME'
        ]
    },
    {
        Q:"马云",
        A:[
            "悔创阿里杰克马？",
            '阿里爸爸',
            'Alibaba创始人'
        ]
    },
    {
        Q:"哈哈",
        A:[
            "哈哈哈",
            '你别笑'
        ]
    },

    //百科类
    {
        Q:"KPMG, 毕马威", 
        A:[
            "毕马威，成立于1897年，总部位于荷兰阿姆斯特丹，是一家网络遍布全球的专业服务机构。 毕马威提供三类主营服务，分别是：审计、税务和咨询。毕马威是四大国际会计师事务所之一，而其他三大分别是普华永道、德勤和安永。"
        ]
    },
    {
        Q:"KDi", 
        A:[
            "KPMG智能创新空间"
        ]},
    {
        Q:"Weitao Xu", 
        A:[
            "He made me"
        ]
    },
    {
        Q:"帅哥的表情图", 
        A:[
            "gtl.GIF",
            "cgx.GIF"
        ]
    },
    {
        Q:"搜索一下,百度一下,谷歌一下", 
        A:[
            "SEARCH"
        ]
    },
]

var QA_Count=QA.length;