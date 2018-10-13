//初始化操作
var categoryParentId = $("a[category_parent_id]:eq(0)").attr('category_parent_id');//服务类型
var categoryId = null;//服务分类
var price = "";//价格
var area= "";//地区
var school = "";//院校
$("a[category_parent_id]:eq(0)").css('color','red');
initSecondCategory();//初始化服务分类高度

/**
 * 初始化分页
 */
var pageSize=6;
$('#pagination').jqPaginator({
	totalCounts : 100,//设置分页的总条目数
	pageSize : pageSize,//设置每一页的条目数
    visiblePages: 10,
    currentPage: 1,
    first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',  	// 首页的HTML样式
    prev: '<li class="prev"><a href="javascript:void(0);"><</a></li>',		// 上一页的HTML样式
    next: '<li class="next"><a href="javascript:void(0);">></a></li>',		// 下一页的HTML样式
    last: '<li class="last"><a href="javascript:void(0);">末页</a></li>',		// 最后一页的样式
    page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',	// 当前页样式
    onPageChange: function (num, type) {						// 点页码的回调
    	searchData(num,this.pageSize);
    }
});

/**
 * 初始化服务分类高度
 */
function initSecondCategory(){
	if($('.secondCategory>.search-list-r').height() == '36'){
		$('.secondCategoryTaggle i').css('background-position','0px 0px');
		$('.secondCategory>.search-list-r').css('height','auto');
	}else{
		$('.secondCategoryTaggle i').css('background-position','-30px -21px');
		$('.secondCategory>.search-list-r').css({'height':'36px','overflow':'hidden'});
	}
}
/**
 * 点击城市列表下拉箭头
 */
$('.cityTaggle').click(function(){		
	if($(this).siblings('.search-list-r').height() == '36'){	
		$(this).children('i').css('background-position','-30px -48px');
		$('.city>.search-list-r').css('height','auto');
	}else{
		$(this).children('i').css('background-position','-30px -21px');
		$('.city>.search-list-r').css({'height':'36px','overflow':'hidden'});
	}
});

/**
 * 点击服务分类下拉箭头
 */
$('.secondCategoryTaggle').click(function(){		
	if($(this).siblings('.search-list-r').height() == '36'){	
		$(this).children('i').css('background-position','-30px -48px');
		$('.secondCategory>.search-list-r').css('height','auto');
	}else{
		$(this).children('i').css('background-position','-30px -21px');
		$('.secondCategory>.search-list-r').css({'height':'36px','overflow':'hidden'});
	}
});

/**
 * 点击服务分类按钮
 */
$("a[category_parent_id]").click(function(){
	if($(this).css('color') == 'red'){
		return;
	}
	categoryParentId = $(this).attr("category_parent_id");//服务分类ID
	categoryId = null;
	$("a[category_parent_id]").css('color','#8D8D8D');
	$(this).css('color','red');
	
	$.ajax({
     	type :"post" ,
     	url :"/qiji/category/getSecondCategory",
     	data :{
     		category_parent_id : categoryParentId
     	},
     	dataType: "json" ,
     	async :true ,
     	success: function(data) {
     		if(data.operSucc && data.succ){
     			var htmlA = "";
     			for(var i=0;i<data.obj.length;i++){
     				htmlA= htmlA + '<a href="javascript:void(0)" category_id="' + data.obj[i].id + '">'+ data.obj[i].name + '</a>';
     			}
     			$('#require_secondCategoryLists').html(htmlA);
     			initSecondCategory();//初始化服务分类高度
     			//重新注册click事件
     			$("a[category_id]").click(function(){
     				secondCategroyClick(this);
     			});
     			
     			searchData(1,pageSize);
     		}else{
     			
     		}
     	},
        error: function(data) {
        	
       }
	});
	
});

function secondCategroyClick(_this){
	categoryId = $(_this).attr("category_id");
	if($(_this).css('color') == 'red'){
		return;
	}
	$("a[category_id]").css('color','#8D8D8D');
	$(_this).css('color','red');
	searchData(1,pageSize);
}
$("a[category_id]").click(function(){
	secondCategroyClick(this);
});



/**
 * 查询
 * @param page 当前页
 * @param rows 每页记录数
 */
function searchData(currentPage,pageSize){

	$.ajax({
     	type :"post" ,
     	url :"/qiji/activity/getActivityList",
     	data :{
     		page : currentPage,
     		rows : pageSize,
     		categoryParentId : categoryParentId,
     		categoryId : categoryId,
     		price : price
     	},
     	dataType: "json" ,
     	async :true ,
     	success: function(data) {
     		if(data.operSucc && data.succ){
     			if(data.obj.totalNum > 0){
                    $('#pagination').jqPaginator('option', {
                    	totalCounts: data.obj.totalNum//总记录数
                    });
                }else{
                	$('#pagination').jqPaginator('option', {
                		totalCounts: 0
                    });
                }

     			var htmlA = "";
     			for(var i=0;i<data.obj.items.length;i++){
     				htmlA= htmlA +  
     				'<div class="required-list" ><div class="required-list-l left"><img src="http://qj101.com/' + data.obj.items[i].activityPictureUrl + 
     				'" style="height:150px;width:230px;"/></div><div class="required-list-r left">' +
					'<h4 style="float:left;">' + '需求类型 : ' + data.obj.items[i].parentCategoryName + '</h4>' + 
					'<p style="margin-left:20px;display:inline;">' + '需求名称 : ' + data.obj.items[i].categoryName + '推广' + '</p>' + 
					'<p>企业名称 : ' + data.obj.items[i].activityOgname + '</p>' + 
					'<p>需求简介 : ' + data.obj.items[i].activityContent + '</p>' + 
					'<span>地区 : ' + data.obj.items[i].activityAddress + '</span>' + 
					'<span>预算 : ' + data.obj.items[i].activityActback + '</span>' + 
					'<span>开始时间 : ' + data.obj.items[i].activityStartTime + '</span>' + 
					'<div class="required-bottom-info">' + 
					'<span>结束时间 : ' + data.obj.items[i].activityEndTime + '</span>' + 
					'<span class="right">距离抢单结束时间还有：<span class="countdown"><span hidden="true">' + data.obj.items[i].activityEndTime + '</span>' + 
					'<i class="days">00</i><i class="days_ref"> 天  </i><i class="hours">00</i>	<i>:</i><i class="minutes">00</i><i>:</i><i class="seconds">00</i></span></span></div>' + 
					'<span style="display:none;">' + data.obj.items[i].activityActid + '</span><a href="/qiji/requireXQ?activityActid=' + data.obj.items[i].activityActid + '" class="head-btn">马上抢</a></div></div>'
				}
     			$('.required-main').html(htmlA);
     			
     		}else{
     			
     		}
     	},
        error: function(data) {
        	
       }
	});
	
	
}








$('.countdown').each(function(index,element){
	
	$(this).downCount({
		date: $(this).find('span:first-child').html(),
		offset: +10
	}, function () {
		$(element).html('<i>已结束</i>');
	});
});