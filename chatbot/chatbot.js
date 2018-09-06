var botui = new BotUI('Bot-Alice');

botui.message.bot("Hi, I'm Alice. ")
  .then(function(){
    botui.message.bot({
      delay:500,
      content:"How are you doing?"
    })
    .then(function(){
      chat()
    })
  });

var chat = function (){
  botui.action.text({
      delay: 500,
      action: {
        placeholder: "  "
      }
    })
  .then(function(res){
    if(res.value == 'EXIT'){
      return leave();
    }
    if(res.value == 'LEARN'){
      return learn();
    }
    // getAnswer
    var ans = getAns(res.value,QA);
    if(ans =='CURRENTTIME'){
      ans ='' + new Date(); 
    }
    if(ans.search('GIF')!= -1){
      return embed(ans);
    }
    if(ans=='SEARCH'){
      return search(res.value);
    }
    botui.message.bot({
      delay:500,
      content:ans
    })
    chat();
  })
}

function leave(){
  botui.message.bot("Are you leaving me now?")
  botui.action.button({
    delay:500,
    action: [
      {
        text: 'Yes',
        value: 'yes'
      }, 
      {
        text: 'Nope',
        value: 'no'
      }
    ]
  })
  .then(function (res) {
    if(res.value == 'yes') {
      return endChat()
    } else {
      botui.message.bot("So talk to me")
      .then(function(){
        chat()
      })
    }
  })
}

var continuee= function(){
  botui.message.bot({
    delay:500,
    content:"Continue ?"
  })
  .then(function(){
    return botui.action.button({
      // delay: 500,
      action: [
        {
          text: 'Yes',
          value: 'yes'
        }, 
        {
          text: 'Nope',
          value: 'no'
        }
      ]
    }).then(function(res){
      if(res.value == 'no'){
        return chat();
      }else{
        return learn();
      }
    })
  })
}

var getAnswer = function(res){
  var ans = getAns(res.value);
  botui.message.bot({
    delay:500,
    content:ans
  })
}

var endChat = function (){
  botui.message.bot({
    delay: 500,
    content: 'Okey, Bye~'
  })
}

//获取输入str
function getInputStr(str){
  botui.action.text({
    delay: 500,
    action: {
      placeholder: "Input " + str
    }
  }).then(function(res){
    alert(res.value)
  })

}

function learn(){
  var question = ''
  var answer = []
  botui.message.bot({
    delay:500,
    content:"The question is?"
  })
  .then(function(){
    return botui.action.text({
      delay: 1000,
      action: {
        placeholder: 'Input question'
      }
    })
  })
  .then(function(res){
    question = res.value
    botui.message.bot({
      delay:500,
      content: "So what's the answer?"
    });
    
    return botui.action.text({
      delay: 1000,
      action: {
        placeholder: 'Input answer'
      }
    })
  })
  .then(function(res){
    answer.push(res.value);
    var newQA = {Q:question, A:answer}
    QA.push(newQA);
    botui.message.bot({
        delay:1000,
        content: "Ok,I've learned that."
    }).then(function(){
      // return continuee();
      botui.message.bot({
        delay:500,
        content: "Ask me"
    })
      return chat()
    })
  })
}

function embed(str){
  botui.message.bot({
    delay:500,
    type:'embed',
    content:"./img/"+ str
  })
  .then(function(){
    return chat()
  })
}

//http://www.goole.com/search?h/=zh-CH&q=
function search(str){
  return botui.message.bot({
    delay:500,
    content:'Searching...'
  })
  .then(function(){
    window.open('http://www.baidu.com/s?wd='+str,'')
    return chat()
  })
}


