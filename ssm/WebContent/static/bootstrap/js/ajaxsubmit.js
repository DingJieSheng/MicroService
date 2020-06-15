// 基于准备好的dom，初始化echarts实例
var myChart1 = echarts.init(document.getElementById('CNNLSTMCHART'));
var myChart2 = echarts.init(document.getElementById('CNNCHART'));
var myChart3 = echarts.init(document.getElementById('LSTMCHART'));
var myChart4 = echarts.init(document.getElementById('LSTMCNNCHART'));

myChart1.setOption({
    title: {
        text: 'CNNLSTM',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['Positive','Negative']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name: 'Probability plot',
            type: 'pie',
            roseType:'radius',
            radius:'50%' ,
            center: ['50%', '60%'],
            data:[
                {value:0,name:'Positive'},
                {value:0,name:'Negative'}
            ],
            itemStyle: {
                //鼠标hover时显示
                emphasis:{
                    // 阴影的大小
                    shadowBlur: 200,
                    // 阴影水平方向上的偏移
                    shadowOffsetX: 0,
                    // 阴影垂直方向上的偏移
                    shadowOffsetY: 0,
                    // 阴影颜色
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
});

myChart2.setOption({
    title: {
        text: 'CNN',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['Positive','Negative']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name: 'Probability plot',
            type: 'pie',
            roseType:'radius',
            radius:'50%' ,
            center: ['50%', '60%'],
            data:[
                {value:0,name:'Positive'},
                {value:0,name:'Negative'}
            ],
            itemStyle: {
                //鼠标hover时显示
                emphasis:{
                    // 阴影的大小
                    shadowBlur: 200,
                    // 阴影水平方向上的偏移
                    shadowOffsetX: 0,
                    // 阴影垂直方向上的偏移
                    shadowOffsetY: 0,
                    // 阴影颜色
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
});

myChart3.setOption({
    title: {
        text: 'LSTM',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['Positive','Negative']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name: 'Probability plot',
            type: 'pie',
            roseType:'radius',
            radius:'50%' ,
            center: ['50%', '60%'],
            data:[
                {value:0,name:'Positive'},
                {value:0,name:'Negative'}
            ],
            itemStyle: {
                //鼠标hover时显示
                emphasis:{
                    // 阴影的大小
                    shadowBlur: 200,
                    // 阴影水平方向上的偏移
                    shadowOffsetX: 0,
                    // 阴影垂直方向上的偏移
                    shadowOffsetY: 0,
                    // 阴影颜色
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
});

myChart4.setOption({
    title: {
        text: 'LSTMCNN',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['Positive','Negative']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name: 'Probability plot',
            type: 'pie',
            roseType:'radius',
            radius:'50%' ,
            center: ['50%', '60%'],
            data:[
                {value:0,name:'Positive'},
                {value:0,name:'Negative'}
            ],
            itemStyle: {
                //鼠标hover时显示
                emphasis:{
                    // 阴影的大小
                    shadowBlur: 200,
                    // 阴影水平方向上的偏移
                    shadowOffsetX: 0,
                    // 阴影垂直方向上的偏移
                    shadowOffsetY: 0,
                    // 阴影颜色
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
});


function setOption(results) {
// 使用刚指定的配置项和数据显示图表。
    if(results[0]>0){
        myChart1.hideLoading()
        myChart1.setOption({
            series: [{
                // // 根据名字对应到相应的系列
                // name: '销量',
                data:[
                    {value:results[0], name:'Positive'},
                    {value:1-results[0], name:'Negative'},
                ]
            }]
        });
    }
    if(results[1]>0){
        myChart2.hideLoading()
        myChart2.setOption({
            series: [{
                // // 根据名字对应到相应的系列
                // name: '销量',
                data:[
                    {value:results[1], name:'Positive'},
                    {value:1-results[1], name:'Negative'},
                ]
            }]
        });
    }
    if(results[2]>0){
        myChart3.hideLoading()
        myChart3.setOption({
            series: [{
                // // 根据名字对应到相应的系列
                // name: '销量',
                data:[
                    {value:results[2], name:'Positive'},
                    {value:1-results[2], name:'Negative'},
                ]
            }]
        });
    }
    if(results[3]>0){
        myChart4.hideLoading()
        myChart4.setOption({
            series: [{
                // // 根据名字对应到相应的系列
                // name: '销量',
                data:[
                    {value:results[3], name:'Positive'},
                    {value:1-results[3], name:'Negative'},
                ]
            }]
        });
    }
}

function predict() {
    // var scrollLink = document.getElementsByClassName('scroll')[0];
    // scrollLink.click();
    var netselection = document.getElementsByName("network");
    var check_val = [];
    for(i=0;i<netselection.length;i++){
        if(netselection[i].checked)
            check_val.push(netselection[i].value);
    }
    var text = $('textarea[name=text]').val();
    if(check_val.length <= 0){
        alert("Please select an analysis algorithm!");
        return
    }
    if(!text || text === ''){
        alert("Please enter the text you want to analyze!")
        return
    }
    for(var i = 0;i<check_val.length;i++){
        if(check_val[i]==0){
            myChart1.showLoading()
        }
        else if(check_val[i]==1){
            myChart2.showLoading()
        }
        else if(check_val[i]==2){
            myChart3.showLoading()
        }
        else if(check_val[i]==3){
            myChart4.showLoading()
        }
    }
    var pathName = window.location.pathname;
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: projectName+"/analysis" ,//url
        data: $('#textinfo').serialize(),
        success: function (data) {
//            if (data.code == 100) {
//                alert("SUCCESS");
//            }
            results = [];
            results.push(data.resultMap.resultMap.result1);
            results.push(data.resultMap.resultMap.result2);
            results.push(data.resultMap.resultMap.result3);
            results.push(data.resultMap.resultMap.result4);
//            alert(results);
            setOption(results);
        },
        error : function() {
            myChart1.hideLoading()
            myChart2.hideLoading()
            myChart3.hideLoading()
            myChart4.hideLoading()
            alert("Exception!");
        }
    });
}

function goback() {
    window.history.go(-1)
}

