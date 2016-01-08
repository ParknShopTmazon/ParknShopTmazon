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
 *      - Update Time: Jan 7, 2015 
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
        /**
         * [initDate: init the date]
         * @return {[type]} [description]
         */
        function initDate() {
            const dateObj = new Date();
            const year = dateObj.getFullYear();
            const month = String(dateObj.getMonth() + 1).length == 1 ? '0' + (dateObj.getMonth() + 1) : dateObj.getMonth() + 1;
            const dateVal = String(dateObj.getDate() + 1).length ? '0' + dateObj.getDate() : dateObj.getDate();
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

        function showOrders(oid, start, end) {
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
                        if (oid !== '-1' && oid !== $(this).find('.shopId').find('.value').html()) {
                            $(this).hide();
                            i++;
                        }
                    });

                    if (i === $shopLists.length) {
                        $(this).hide();
                    }
                }
            });
        }

        initDate();

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
                    window.location.href = 'modifyorder?oid=' + oid + '&pid=' + pid;
                });
            }
        });

        $('.shops-orders-container #shopId, .shops-orders-container #startDate, .shops-orders-container #endDate').change(function(event) {
            /* Act on the event */
            showOrders($('.shops-orders-container #shopId').val(), $('.shops-orders-container #startDate').val(), $('.shops-orders-container #endDate').val());
        });
    }
};
