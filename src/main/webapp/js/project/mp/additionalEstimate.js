var myTbContentId = 'mytbc1';
var myJqTbContentId = '#' + myTbContentId;
var myTbId = 'myt1';
var myJqTbId = '#' + myTbId;
var myPageId = 'myp1';
var myJqPageId = '#' + myPageId;

$(function() {
	$("#startDate").val(laydate.now() + ' 00:00:00');
	$("#endDate").val(laydate.now(1) + ' 00:00:00');
	
	var t1 = $('<table></table>');
	t1.attr('id', myTbId);
	$(myJqTbContentId).append(t1);

	var p1 = $('<div></div>');
	p1.attr('id', myPageId);

	p1.insertAfter(t1);

	$(myJqTbId).jqGrid({
		url : basePath + 'additionalEstimateList?' + $("#searchForm").serialize(),
		mtype : "GET",
		datatype : "json",
		caption : "加款预估统计列表", //设置表标题
		page : 1,
		colNames : ['通道名称', '消耗总额', '余额'],
		colModel : [
		             {name : 'name',sortable : false,align: 'center'},
		             {name : 'cutmoney',sortable : false,align: 'center'},
		             {name : 'balance',sortable : false,align: 'center'}
		           ],
		height : 'auto',
		multiselect:true,//多选框
		multiboxonly:true,//为true时是单选
		autowidth : true,
		shrinkToFit : true,
		hidegrid : false, //隐藏表格右上角的"展开/收缩jqGrid内容的小箭头"
		autoScroll : false,
		rowNum : myRowNum,
		rowList : myRowList,
		viewrecords : true,//显示总记录数
		pager : myJqPageId
	});

    setMyActive(7,6); //设置激活页
});

/*绑定日期控件*/
laydate({
	elem: '#startDate',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	event: 'focus', 	//响应事件。如果没有传入event，则按照默认的click
	format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	istime: true, //是否开启时间选择
});

/*绑定日期控件*/
laydate({
	elem: '#endDate',	//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	event: 'focus',		//响应事件。如果没有传入event，则按照默认的click
	format: 'YYYY-MM-DD hh:mm:ss', //日期格式
	istime: true, //是否开启时间选择
});

function search(){
	var data = $("#searchForm").serialize();
	$('#myt1').jqGrid('setGridParam',{ 
	        url:basePath+'additionalEstimateList?'+data, 
	        page:1 
    }).trigger("reloadGrid"); //重新载入
}

function exportExcel(){
	var data = $("#searchForm").serialize();
	location.href = "checkBalance?"+data;
}