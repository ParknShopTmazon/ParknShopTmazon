/***********************************************************************
 *                                                                   _
 *       _____  _                           ____  _                 |_|
 *      |  _  |/ \   ____  ____ __ ___     / ___\/ \   __   _  ____  _
 *      | |_| || |  / __ \/ __ \\ '_  \ _ / /    | |___\ \ | |/ __ \| |
 *      |  _  || |__. ___/. ___/| | | ||_|\ \___ |  _  | |_| |. ___/| |
 *      |_/ \_|\___/\____|\____||_| |_|    \____/|_| |_|_____|\____||_| 
 *                                                                      
 *      ================================================================
 *                 More than a coder, More than a designer              
 *      ================================================================
 *
 *
 *      - Document: shopowner.js
 *      - Author: aleen42
 *      - Description: including all the function of shop owner role.
 *      - Create Time: Jan 7, 2015
 *      - Update Time: Jan 9, 2015 
 *
 *
 **********************************************************************/
"use strict";
/** Date format */
Date.prototype.format = function(format) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
        }
    }
    return format;
}

String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
}

const shopOwner = {
    /**
     * [scrollController: the controller of the scroll]
     * @return {[type]} [description]
     */
    scrollController: {
        disableScroll: function (object) {
            "use strict";
            object.addClass('fix-scroll');
        },

        enableScroll: function (object) {
            "use strict";
            object.removeClass('fix-scroll');
        }
    },

    /**
     * [initCommon: init common part]
     * @return {[type]} [description]
     */
    init: function () {
        $('.back-btn').click(function() {
            history.go(-1);
        });

        $('#price').change(function(event) {
            /* Act on the event */
            if(isNaN($(this).val())) {
                $(this).focus();
                $(this).val('');
                alert('please input a number');
            } else {
                $(this).val(parseFloat($(this).val()).toFixed(2));
            }
        });

        $('#stock_num').change(function(event) {
            /* Act on the event */
            const regex = new RegExp("^[0-9]*[1-9][0-9]*$");
            if (regex.test($(this).val())) {
                /** do something */
            } else {
                $(this).focus();
                $(this).val('');
                alert('you can only input an integer');
            }
        });
    },

    /**
     * [initManage: init common part of shop management]
     * @return {[type]} [description]
     */
    initManage: function () {
        $('#menu #products-list, #menu #add-products, #menu #manage-orders').addClass('active');
        $('#menu #products-list').parent().attr('href', 'selectedshop');
        $('#menu #add-products').parent().attr('href', 'addproduct');
        $('#menu #manage-orders').parent().attr('href', 'shoporder');
    },

    /**
     * [initMenu: init the menu]
     * @return {[type]} [description]
     */
    initMenu: function () {
        $('#menu .menu-btn').click(function(event) {
            /* Act on the event */
            let backgroundImage;
            let $left = $(this).parent().css('left');
            $left = $left === '0px' ? '-300px' : '0px';
            backgroundImage = $left === '0px' ? 'url(./images/products-btn.png)' : 'url(./images/products-btn-close.png)'
            $(this).parent().css({
                'left': $left
            });

            $(this).css({
                'background-image': backgroundImage
            });
        });
    },

    /**
     * [initList: init the shops list]
     * @return {[type]} [description]
     */
    initList: function () {
        $('#menu #shops-list').addClass('selected');
    },

    /**
     * [initRegister: init the register page]
     * @return {[type]} [description]
     */
    initRegister: function () {
        $('#menu #add-shops').addClass('selected');
    },

    /**
     * [initProductList: init the products list page]
     * @return {[type]}        [description]
     */
    initProductList: function () {
        $('#menu #products-list').addClass('selected');
    },

    /**
     * [initAddProducts: init the produts add page]
     * @return {[type]}        [description]
     */
    initAddProducts: function () {
        $('#menu #add-products').addClass('selected');
    },

    /**
     * [initOrderList: init the order-list]
     * @return {[type]} [description]
     */
    initOrderList: function () {
        let amount = {};
    	/**
         * [initDate: init the date]
         * @return {[type]} [description]
         */
        function initDate() {
            const dateObj = new Date();
            const year = dateObj.getFullYear();
            const month = String(dateObj.getMonth() + 1).length == 1 ? '0' + (dateObj.getMonth() + 1) : dateObj.getMonth() + 1;
            const dateVal = String(dateObj.getDate() + 1).length == 1 ? '0' + dateObj.getDate() : dateObj.getDate();
            const today = [year, month, dateVal].join('-');
            const theFirstDate = [year, month, '01'].join('-');
            $('.shops-orders-container #startDate').val(theFirstDate);
            $('.shops-orders-container #endDate').val(today);
        }
        
        /**
         * [compareDate: compare two date, return 1 when the prev one is greater than the next one with the format yyyy-MM-dd. Otherwise, return -1]
         * @param  {[type]}   prev [prev date]
         * @param  {Function} next [description]
         * @return {[type]}        [description]
         */
        function compareDate(prev, next) {
            const prevArray = prev.split('-');
            const nextArray = next.split('-');
            
            /** year */
            if ((prevArray[0] >> 0) < (nextArray[0] >> 0)) {
            	return -1;
            }
            
            /** month */
            if ((prevArray[1] >> 0) < (nextArray[1] >> 0)) {
            	return -1;
            }
            
            /** date */
            if ((prevArray[2] >> 0) <= (nextArray[2] >> 0)) {
            	return -1;
            }
            
            return 1;
        }
        
        function calculateAmount() {
        	 const $orderLists = $('.order-item');
        	 const $shopNames = $('#shopId').children('option');
        	 
        	 $shopNames.each(function() {
        		if ($(this).html() === 'ALL') {
      				return;
      			}
      			
        		amount[$(this).val()] = {};
         	});
             
             $orderLists.each(function() {
            	 const $shopLists = $(this).children('.shop-item');
            	 const dateTime = $(this).find('.brief-info').find('.order-ctime').find('.value').html().split(' ')[0];
            	 
            	 $shopLists.each(function() {
            		 let sum = 0.0;
            		 const shopId = $(this).find('.shopId').find('.value').html();
            		 
            		 if (typeof(amount[shopId][dateTime]) == 'undefined') {
                		 amount[shopId][dateTime] = 0.0;
                	 }
            		 
            		 const status = $(this).find('.info').find('.delivery-status').find('.value').html();
            		 let salary = $(this).find('.price').find('.shop-price').html();
            		 salary = salary.trim();
            		 salary = parseFloat(salary.substr(1, salary.length));
            		 if (status === 'commented' || status === 'dealed') {
            			 sum += salary; 
            		 } 
            		 amount[shopId][dateTime] += sum;
				 });
             });
             console.log(amount);
        }
        
        function initChart(sid, start, end) {
        	$("#chart-container").empty();
        	
        	if (compareDate(start, end) > 1) {
        		return;
        	}
        	
        	const $shopNames = $('#shopId').children('option');
        	const _sid = sid;

        	let markDate = {};
        	let dataSets = [];
        	
        	/** foreach shop to find the date of them */
        	$shopNames.each(function() {
        		const valSets = [];
        		for (let i in amount[$(this).val()]) {
        			if (compareDate(start, i) > 0 || compareDate(i, end) > 0) {
        				continue;
        			} else {
        				valSets.unshift({
        					'value': amount[$(this).val()][i]
        				});
        				
        				/** mark the date */
            			markDate[i] = 0;
        			}
                }
        		
    			if (_sid === '-1') {
    				if ($(this).html() === 'ALL') {
        				return;
        			}
            		dataSets.push({
            			'seriesname': $(this).html(),
            			'data': valSets
            		});
    			} else {
    				if ($(this).val() == _sid) {
    					dataSets.push({
                			'seriesname': $(this).html(),
                			'data': valSets
                		});
    				}
    			}
        	});
        	
        	let categories = [];
        	/** generate the categories */
        	for (let i in markDate) {
        		categories.unshift({
        			'label': i
        		});
        	}
        	
        	/** calculate the average value */
        	const avgSets = [];
        	
        	if (dataSets.length > 1) {
        		for(let i = 0; i < dataSets[0].data.length; i++) {
            		let avg = 0;
            		for(let j = 0; j < dataSets.length; j++) {
                		if (typeof(dataSets[j].data[i]) == 'undefined') {
                			avg += 0;
                		} else {
                			avg += dataSets[j].data[i].value;
                		}
            		}
            		
            		avgSets.push({
            			'value': String((avg / dataSets.length).toFixed(2))
            		});
        		}
        	}
        	
        	if (avgSets.length !== 0) {
        		dataSets.push({
                    "seriesname": "Average",
                    "renderas": "line",
                    "showvalues": "0",
                    "data": avgSets
                });
        	}

        	$("#chart-container").insertFusionCharts({
                type: "mscombi2d",
                width: "100%",
                height: "480",
                dataFormat: "json",
                dataSource: {
                    "chart": {
                        "caption": "Incomes of your shops",
                        "xaxisname": "Date",
                        "yaxisname": "Amount (In USD)",
                        "numberprefix": "$",
                        "theme": "fint",
                    },
                    "categories": [
                        {
                            "category": categories
                        }
                    ],
                    "dataset": dataSets
                }
            });
        }

        function showOrders(sid, start, end) {
            const $orderLists = $('.order-item');
            
            $orderLists.each(function() {
                const $shopLists = $(this).children('.shop-item');
                const dateTime = $(this).find('.brief-info').find('.order-ctime').find('.value').html().split(' ')[0];
                let i = 0;
                $(this).show();

                if (compareDate(start, dateTime) > 0 || compareDate(dateTime, end) > 0) {
                	$(this).hide();
                } else {
                	$shopLists.each(function() {
                        $(this).show();
                        if (sid !== '-1' && sid !== $(this).find('.shopId').find('.value').html()) {
                            $(this).hide();
                            i++;
                        }
                    });

                    if (i === $shopLists.length) {
                        $(this).hide();
                    }
                }
            });
            
            initChart(sid, start, end);
        }

        initDate();
        
        calculateAmount();
        
        showOrders('-1', $('.shops-orders-container #startDate').val(), $('.shops-orders-container #endDate').val());

        const $listBtns = $('.shops-orders-container #order-list .order-item .handle-btn');

        $listBtns.each(function() {
            if ($(this).attr('status') !== 'paid') {
                $(this).css({
                    'border': '1px solid #e0e0e0',
                    'background-color': '#f0f0f0',
                    'color': '#e0e0e0'
                });
            } else {
                const _this = $(this);
                const oid = $(this).attr('oid');
                const pid = $(this).attr('pid');
                
                $(this).click(function(event) {
                    /* Act on the event */
                    $.getJSON('changeOrderInfo', {
                        oid: oid,
                        pid: pid,
                        newStatus: 'delivering'
                    }, function(data, textStatus) {
                        /*optional stuff to do after success */
                        if (data.success) {
                            _this.css({
                                    'border': '1px solid #e0e0e0',
                                    'background-color': '#f0f0f0',
                                    'color': '#e0e0e0'
                                });

                            _this.removeClass('button');

                            _this.unbind('click');
                            
                            _this.prev().find('.delivery-status').find('.deliver').html('delivering');
                        } else {
                            alert('faied to send products');
                        }
                    });
                });
            }
        });

        $('.shops-orders-container #shopId, .shops-orders-container #startDate, .shops-orders-container #endDate').change(function(event) {
            /* Act on the event */
            showOrders($('.shops-orders-container #shopId').val(), $('.shops-orders-container #startDate').val(), $('.shops-orders-container #endDate').val());
        });
    },
    
    initShow: function (oid, item) {
    	$.getJSON('orderByType', {
            type: 'shopOwnerShow',
            oid: oid
        }, function(data, textStatus) {
        	let date = new Date();
            let deliveryTime = new Date();
            let dealTime = new Date();

            /** item should not be greater than the actual quantity */
            if (item >= data.orderInfos.length) {
                return;
            }

            date.setTime(data.orderTime.time);
            if (data.orderInfos[item].deliveryTime) {
                deliveryTime.setTime(data.orderInfos[item].deliveryTime.time);
                deliveryTime = deliveryTime.format('yyyy-MM-dd hh:mm');
            } else {
                deliveryTime = '/';
            }

            if (data.orderInfos[item].dealTime) {
                dealTime.setTime(data.orderInfos[item].dealTime.time);
                dealTime = dealTime.format('yyyy-MM-dd hh:mm');
            } else {
                dealTime = '/';
            }
        	
            /*optional stuff to do after success */
           $('.detail-container #order-info').append('<div class="shop-info">\
                   <div class="pic-container">\
                   <a href="' + data.orderInfos[item].productUrl + '" target="_blank">\
                       <div class="over">\
                           <div class="link-btn" style="background-image: url(./images/link-btn.png);"></div>\
                       </div>\
                   </a>\
                   <div class="shop" style="background-image: url(' + data.orderInfos[item].product.picture + ');"></div>\
               </div>\
               <div class="info">\
                   <div class="item">\
                       <span class="name">Order Id</span>\
                       <span class="value">' + data.orderId + '</span>\
                   </div>\
                   <div class="item">\
	                   <span class="name">Product Id</span>\
                       <span class="value">' + data.orderInfos[item].productId + '</span>\
	               </div>\
	               <div class="item">\
	                   <span class="name">Quantity</span>\
	                   <span class="value special">' + data.orderInfos[item].quantity + '</span>\
	               </div>\
                   <div class="item">\
	                   <span class="name">User Name</span>\
	                   <span class="value">' + data.userName + '</span>\
	               </div>\
                   <div class="item">\
                       <span class="name">Receiver Name</span>\
                       <span class="value special">' + data.address.name + '</span>\
                   </div>\
                   <div class="item">\
	                   <span class="name">Phone Number</span>\
	                   <span class="value special">' + data.address.phone + '</span>\
	               </div>\
                   <div class="address item">\
                       <span class="name">Address</span>\
                       <span class="value special">' + data.address.description + '</span>\
                   </div>\
                   <div class="time item">\
                       <span class="name">Create Time</span>\
                       <span class="value">' + date.format('yyyy-MM-dd hh:mm') + '</span>\
                   </div>\
                   <div class="item">\
                       <span class="name">Delivery Time</span>\
                       <span class="value">' + deliveryTime + '</span>\
                   </div>\
                   <div class="item">\
                       <span class="name">Deal Time</span>\
                       <span class="value">' + dealTime + '</span>\
                   </div>\
               </div>\
           </div>\
           <div class="shop-right-item" style="margin-top: 10%;">\
               <span class="name">status</span>\
               <span class="value">' + data.orderInfos[item].status + '</span>\
           </div>\
           <div class="shop-right-item" style="margin-top: 14%;">\
	           <span class="name">delivery company</span>\
	           <span class="value">' + data.orderInfos[item].delivery.company + '</span>\
	       </div>\
	       <div class="shop-right-item" style="margin-top: 18%;">\
	           <span class="name">delivery options</span>\
	           <span class="value">' + data.orderInfos[item].delivery.type + '</span>\
	       </div>'); 
        });
    }
};
