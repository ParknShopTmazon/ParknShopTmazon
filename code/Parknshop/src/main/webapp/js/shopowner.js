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
    },

    /**
     * [initManage: init common part of shop management]
     * @return {[type]} [description]
     */
    initManage: function () {
        $('#menu #products-list, #menu #add-products').addClass('active');
        $('#menu #products-list').parent().attr('href', 'selectedshop');
        $('#menu #add-products').parent().attr('href', 'addproduct');
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
    }
};
