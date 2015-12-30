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
 *      - Document: customer.js
 *      - Author: aleen42
 *      - Description: including all the function of customer role, this
 *                     file is a javascript file to control all the 
 *                     interaction of customers. 
 *      - Create Time: Dec 9, 2015
 *      - Update Time: Dec 21, 2015 
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

var customer = {
    /**
     * [scrollController: the controller of the scroll]
     * @return {[type]} [description]
     */
    scrollController: {
        disableScroll: function(object) {
            "use strict";
            object.addClass('fix-scroll');
        },

        enableScroll: function(object) {
            "use strict";
            object.removeClass('fix-scroll');
        }
    },

    /**
     * [init: init common parts]
     * @return {[type]} [description]
     */
    init: function() {
        "use strict";
        var scrollController = this.scrollController;
        /** [click function of the black button] */
        $('.back-btn').click(function() {
            history.go(-1);
        });

        $('.scroll').hover(function() {
            scrollController.disableScroll($(document.body));
        }, function() {
            scrollController.enableScroll($(document.body));
        });

        /** init the dialog */
        this.initDialog();

        /** disable enter key keydown */
        $(document).on("keydown", function(event) {
            var userAgent = navigator.userAgent.toLowerCase();
            var keycode;
            if (userAgent.indexOf('firefox') >= 0 || userAgent.indexOf('ie') >= 0) {
                keycode = event.which;
            } else {
                var ev = (event === undefined) ? window.event : event;
                keycode = ev.keyCode;
            }
            if (keycode === 13) {
                return false;
            }
        });
    },

    /**
     * [initDialog: init the part, dialog]
     * @return {[type]} [description]
     */
    initDialog: function() {
        "use strict";
        /**
         * [stateMacine: the state machine of the operations]
         * @type {String}
         */
        var stateMachine = {
                'main': '',
                'add-friend-main': 'main',
                'people-list-main': 'add-friend-main',
                'certain-add-main': 'people-list-main',
                'certain-delete-main': 'main',
                'notice-add-main': 'people-list-main',
                'notice-del-main': 'main'
            },

            /**
             * [lastStep: to store the last operation]
             * @type {String}
             */
            lastStep = '',

            /**
             * [changeTitle: set the title of the dialog when choosing a person]
             * @param  {[type]} title [the title you want to set]
             * @return {[type]}       [description]
             */
            changeTitle = function(title) {
                $('.dialog #main  h2 > strong').html(title);
            },

            /**
             * [showPart: show the part and hide others]
             * @param  {[type]} part [the part you want to show]
             * @return {[type]}      [description]
             */
            showPart = function(part) {
                $('#somedialog .dialog__content').hide();
                $('#somedialog .dialog__content').removeClass('shown');

                $('#somedialog #' + part).show();
                $('#somedialog #' + part).addClass('shown');

                /** set the last step of this page */
                lastStep = stateMachine[part];
            },

            /**
             * [updateFriendList: update the friends list]
             * @param  {[type]} name [if the name is not null, then choose the name first]
             * @return {[type]}      [description]
             */
            updateFriendList = function(name) {
                /** name is null by default */
                name = name || null;

                $.ajax({
                        url: 'friends',
                        type: 'POST',
                        dataType: 'json',
                        data: {},
                    })
                    .done(function(data) {
                        if (typeof(data.friends) != 'undefined') {
                            /** clear all friends first */
                            for (var i = 0; i < $('.dialog #main .friend-list .list ul').children().length; i++) {
                                $('.dialog #main .friend-list .list ul').children(i).remove();
                            }

                            /** append */
                            for (var j in data.friends) {
                                /** [if: first child] */
                                if (j == 0) {
                                    $('.dialog #main .friend-list .list ul').append('<li class="select button" uid="' + data.friends[j].uid + '">' + data.friends[j].name + '</li>');

                                    /** get the message of choosen name */
                                    getMessage(data.friends[j].name);
                                } else {
                                    if (data.friends[j].name == name) {
                                        /** remove the select class */
                                        $('.dialog #main .friend-list .list ul').children(0).removeClass('select');

                                        $('.dialog #main .friend-list .list ul').append('<li class="select button" uid="' + data.friends[j].uid + '">' + data.friends[j].name + '</li>');

                                        /** get the message of choosen name */
                                        getMessage(data.friends[j].name);
                                    } else {
                                        $('.dialog #main .friend-list .list ul').append('<li class="button" uid="' + data.friends[j].uid + '">' + data.friends[j].name + '</li>');
                                    }
                                }
                            }
                        } else {
                            console.log("failed to get friends list, but post succeed");
                        }
                    })
                    .fail(function() {
                        console.log("failed to get friends list");
                    });
            },

            /**
             * [getMessage: get message from the friend]
             * @param  {[type]} friendName [the name of the friend]
             * @return {[type]}            [description]
             */
            getMessage = function(friendName) {
                /** date object */
                var date = new Date();

                $.ajax({
                        url: 'messages',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            friendName: friendName
                        },
                    })
                    .done(function(data) {
                        if (typeof(data.messages) != 'undefined') {
                            for (var i in data.messages) {
                                date.setTime(data.messages[i].messageTime.time);
                                $('.dialog #main .dialog-show').append('<p class="time">' + date.format('yyyy-MM-dd hh:mm') + '</p>\
            <p>' + data.messages[i].content + '</p>')
                            }
                        } else {
                            console.log("failed to get message, but post succeed");
                        }
                    })
                    .fail(function() {
                        console.log("failed to get message");
                    });
            },

            /**
             * [searchFriends: search friends by the name]
             * @param  {[type]} name [the name]
             * @return {[type]}      [description]
             */
            searchFriends = function(name) {
                $.ajax({
                        url: 'searchUser',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            name: name
                        },
                    })
                    .done(function(data) {
                        if (typeof(data.users) != 'undefined') {
                            /** clear children */
                            for (var i = 0; i < $('.dialog #people-list-main .list ul').children().length; i++) {
                                $('.dialog #people-list-main .list ul').children(i).remove();
                            }

                            /** append */
                            for (var j in data.users) {
                                /** [if: first child] */
                                if (j == 0) {
                                    $('.dialog #people-list-main .list ul').append('<li class="select button">' + data.users[j] + '</li>')
                                } else {
                                    $('.dialog #people-list-main .list ul').append('<li class="button">' + data.users[j] + '</li>')
                                }
                            }
                        } else {
                            console.log("failed to search friends, but post succeed");
                        }
                    })
                    .fail(function() {
                        console.log("failed to search friends");
                    });
            },

            /**
             * [addFriend: add friend by the name]
             * @param {[type]} name [the name]
             */
            addFriend = function(name) {
                $.ajax({
                        url: 'addFriend',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            friendName: name
                        },
                    })
                    .done(function(data) {
                        if (data == 'success') {
                            updateFriendList(name);
                        } else {
                            updateFriendList(name);
                            console.log("failed to add the friend, but post succeed");
                        }
                    })
                    .fail(function() {
                        console.log("failed to add the friend");
                    });
            },

            /**
             * [delFriend: delete friend by the name]
             * @param  {[type]} name [the name]
             * @return {[type]}      [description]
             */
            delFriend = function(name) {
                $.ajax({
                        url: 'deleteFriend',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            friendName: name
                        },
                    })
                    .done(function(data) {
                        if (data == 'success') {
                            updateFriendList();
                        } else {
                            updateFriendList();
                            console.log("failed to delete the friend, but post succeed");
                        }
                    })
                    .fail(function() {
                        console.log("failed to delete the friend");
                    });
            },

            /**
             * [init: init the animation trigger of the` dialog]
             * @return {[type]} [description]
             */
            init = function() {
                var dlgtrigger = document.querySelector('[data-dialog]'),
                    somedialog = document.getElementById(dlgtrigger.getAttribute('data-dialog')),
                    dlg = new DialogFx(somedialog);
                dlgtrigger.addEventListener('click', dlg.toggle.bind(dlg));
            };

        /** init the animation */
        init();

        /** show main first */
        showPart('main');

        /** focus function or blur function of the search box input */
        $('.dialog #add-friend-main .search-box input[type="text"]').focus(function() {
            $(this).attr('placeholder', '');
        }).blur(function() {
            $(this).attr('placeholder', 'search...');
        });

        /** [click function of choosing people to add] */
        $('.dialog #people-list-main .list ul > li').click(function() {
            /** [remove the original selected item] */
            $(this).parent().children('li').each(function() {
                $(this).removeClass('select');
            });

            /** [set the new selected item] */
            $(this).addClass('select');
        });

        /** [click function of choosing friends] */
        $('.dialog #main .friend-list .list ul > li').click(function() {
            /** [remove the original selected item] */
            $(this).parent().children('li').each(function() {
                $(this).removeClass('select');
            });

            /** [set the new selected item] */
            $(this).addClass('select');
            changeTitle($(this).html());
            getMessage($(this).html());
        });

        /** [click function of add friend button] */
        $('.dialog #main .bottom-buttons .add-friend-btn').click(function() {
            showPart('add-friend-main');
        });

        /** [click function of search button on the add friend page] */
        $('.dialog #add-friend-main .search-btn').click(function() {
            showPart('people-list-main');

            /** search friends */
            searchFriends($('.dialog #add-friend-main .search-box input[type="text"]').val());
        });

        /** [click function of certaining to add friends] */
        $('.dialog #people-list-main .bottom-buttons .certain-btn').click(function(event) {
            /* Act on the event */
            if ($('.dialog #people-list-main .list ul .select').length > 0) {
                showPart('certain-add-main');
            } else {
                showPart('notice-add-main');
            }
        });

        /** [click function of certaining] */
        $('.dialog #certain-add-main .bottom-buttons .certain-btn').click(function(event) {
            /* Act on the event */
            addFriend($('.dialog #people-list-main .list ul .select').html());
        });

        /** [click function of certaining to delete friends] */
        $('.dialog #main .bottom-buttons .del-friend-btn').click(function() {
            if ($('.dialog #main .friend-list .list ul .select').length > 0) {
                showPart('certain-delete-main');
            } else {
                showPart('notice-del-main');
            }
        });

        /** [click function of certaining] */
        $('.dialog #certain-delete-main .bottom-buttons .certain-btn').click(function(event) {
            /* Act on the event */
            delFriend($('.dialog #main .friend-list .list ul .select').html());
        });

        /** [click function of the dialog-back-btn] */
        $('.dialog .dialog-back-btn').click(function() {
            showPart(lastStep);
        })

        /** [go back when cancel] */
        $('.dialog .bottom-buttons .cancel-btn').click(function() {
            showPart(lastStep);
        })

        /** [check hover of communication button] */
        $('#communicate-btn').hover(function() {
            $(this).css('width', '120px');
        }, function() {
            $(this).css('width', '30px');
        })

        /** update friends list */
        updateFriendList();
    },

    /**
     * [initRate: init the part, rate]
     * @return {[type]} [description]
     */
    initRate: function() {
        "use strict";
        jQuery("div").webRating({
            // count
            ratingCount: 5,

            // image & color
            imgSrc: "./images/star.png",
            xLocation: 0, //in px
            yLocation: 0, //in px
            width: 30, //in px
            height: 29, //in px

            //CSS
            onClass: 'star-on',
            offClass: 'offClass',
            onClassHover: 'star-hover', //Optional
            offClassHover: 'offClassHover', //Optional

            //on click funcitons
            cookieEnable: true,
            cookiePrefix: "myRating_",
            maxClick: 1000,
            onClick: function(clickScore, data) {
                //Your function & post action
                /** get the rate option */
                var json = JSON.parse(data);
                var option = json.option;
                /** set the rate score */
                $('#' + option + '_rate').val(clickScore);
            },

            //Tooltip
            tp_showAverage: true,
            // prefixAverage: "Avg",
            tp_eachStar: {
                '1': '1 point: Very Bad',
                '2': '2 point: Bad',
                '3': '3 point: Ok',
                '4': '4 point: Good',
                '5': '5 point: Very Good'
            } //Rating guide
        });
    },

    /************************************************************
     *
     * Cart
     *
     ***********************************************************/

    /**
     * [initCart: init the cart page]
     * @return {[type]} [description]
     */
    initCart: function() {
        "use strict";
        var origin_cost, right_cost;
        /**
         * [updateCost: update cost info]
         * @return {[type]} [description]
         */
        var updateCost = function() {
                var list = $('.cart-container #shop-lists .shop-info .price .value');
                var origin_list = $('.cart-container #shop-lists .shop-info .price .value .origin-cost');
                var right_list = $('.cart-container #shop-lists .shop-info .price .value .right-cost');
                var quantity_list = $('.cart-container #shop-lists .shop-info .quantity .value input');
                /** update quantity */
                $('#shop-cost .quantity .value').html(list.length);

                origin_cost = right_cost = 0;
                /** update cost */
                for (var i = 0; i < list.length; i++) {
                    origin_cost += parseInt(quantity_list[i].value) * parseFloat(origin_list[i].textContent.substring(1, origin_list[i].textContent.length));
                    right_cost += parseInt(quantity_list[i].value) * parseFloat(right_list[i].textContent.substring(1, right_list[i].textContent.length));
                }
                $('#shop-cost .origin .value').html('<s>$' + origin_cost.toFixed(1) + '</s>');
                $('#shop-cost .cost .value').html('$' + right_cost.toFixed(1));
            },

            /**
             * [initData: init cart data]
             * @param  {[type]} data [data from the interface]
             * @return {[type]}      [description]
             */
            initData = function(data) {
                /** parse */
                var cart = data.cart;
                for (var i in cart) {
                    /** append list item */
                    $('.cart-container #shop-lists').append('<div class="shop-item">\
                        <div class="pic-container">\
                            <a href="' + cart[i].shop_url + '" target="_blank">\
                                <div class="over">\
                                    <div class="link-btn"></div>\
                                </div>\
                            </a>\
                            <div class="shop" style="background-image: url(' + cart[i].shop_pic + ');"></div>\
                        </div>\
                        <div class="shop-info">\
                            <div class="name main">\
                                <span>Name</span>\
                                <span class="value">' + cart[i].name + '</span>\
                            </div>\
                            <div class="size sub-main">\
                                <span>size</span>\
                                <span class="value">' + cart[i].size + '</span>\
                            </div>\
                            <div class="price sub-main">\
                                <span>price</span>\
                                <span class="value"><span class="origin-cost"><s>$' + cart[i].origin_price + '</s></span>&nbsp;<span class="right-cost">$' + cart[i].price + '</span></span>\
                            </div>\
                            <div class="quantity sub-main">\
                                <span>quantity</span>\
                                <span class="value">\
                                    <input type="number" sid="' + cart[i].sid + '" min="1" max_quantity="' + cart[i].stock + '" value="' + cart[i].quantity + '">\
                                </span>\
                            </div>\
                            <div class="color sub-main">\
                                <span>color</span>\
                                <span class="value" style="background-color: ' + cart[i].color + ';"></span>\
                            </div>\
                            <div class="delete sub-main">\
                                <span class="value button"></span>\
                            </div>\
                        </div>\
                    </div>');
                }
            },

            /**
             * [init: init the cart after initialzing the data]
             * @return {[type]} [description]
             */
            init = function() {
                /** update cost info at the beginning */
                updateCost();

                /** delete shop item */
                $('.cart-container #shop-lists .shop-item .shop-info .delete .value').click(function() {
                    var _this = $(this);
                    /** store data into database */
                    $.getJSON('deleteCart', {
                        sid: $(this).parent().prev().prev().children('.value').children('input').attr('sid')
                    }, function(data, textStatus) {
                        /*optional stuff to do after success */
                        if (typeof(data.result) != 'undefined' && data.result == 'true') {
                            _this.parent().parent().parent().remove();
                            updateCost();
                        } else {
                            var error = data.errMsg || '';
                            alert('failed to delete: ' + error);
                        }
                    });
                });

                /** [click function of the pay button] */
                $('.cart-container #shop-cost .pay .value').click(function() {
                    window.location.href = "./order?type=certain";
                });

                /** [change function of quantity changing] */
                $('.cart-container #shop-lists .shop-info .quantity .value input[type="number"]').change(function(event) {
                    /* Act on the event */
                    var _this = $(this);
                    /** check legality when keydown */
                    var regex = new RegExp("^[0-9]*[1-9][0-9]*$");
                    if (regex.test($(this).val())) {
                        if (parseInt($(this).val()) > parseInt($(this).attr('max_quantity'))) {
                            $(this).focus();
                            $(this).val($(this).attr('max_quantity'));
                            alert('the product is limited for sale');
                        } else {
                            /** store data into database */
                            $.getJSON('updateCart', {
                                sid: $(this).attr('sid'),
                                quantity: $(this).val()
                            }, function(data, textStatus) {
                                /*optional stuff to do after success */
                                if (typeof(data.result) != 'undefined' && data.result == 'true') {
                                    _this.attr('value', _this.val());
                                } else {
                                    var error = data.errMsg || '';
                                    alert('failed to modify: ' + error);
                                    _this.val(_this.attr('value'));
                                }
                            });
                        }
                    } else {
                        $(this).focus();
                        $(this).val(Math.abs(parseInt($(this).val())));
                        alert('you can only enter integer number between 1 and 99');
                    }

                    updateCost();
                });
            };

        /** get data by uid */
        $.ajax({
                url: 'cartInfo',
                type: 'post',
                dataType: 'json',
                data: {},
            })
            .done(function(data) {
                /** init the data of cart */
                initData(data);

                /** init the cart */
                init();
            })
            .fail(function() {
                console.log('failed to get cart data');
            });
    },

    /************************************************************
     *
     * Order
     *
     ***********************************************************/

    /**
     * [initComment: init the comment page of order]
     * @return {[type]} [description]
     */
    initComment: function() {
        "use strict";
        /** init the rate system */
        this.initRate();

        /** post */
        $('.order-container #order-info .comment-submit').click(function() {
            $.ajax({
                    url: '',
                    type: 'post',
                    dataType: 'json',
                    data: {},
                })
                .done(function() {
                    /** init the data of order */
                    initData(data);
                })
                .fail(function() {
                    // console.log("error");
                })
                .always(function() {
                    console.log("complete to comment");
                });
        });
    },

    /**
     * [initCertain: init the page certain]
     * @return {[type]} [description]
     */
    initCertain: function() {
        "use strict";
        var cost;
        /**
         * [updateCost: update cost info]
         * @return {[type]} [description]
         */
        var updateCost = function() {
                var list = $('.order-container #order-details .order-item .order-price .shop-price');
                var quantity = $('.order-container #order-details .quantity input[type="number"]');
                var price = $('.order-container #order-details .order-item .order-origin-price span');
                var delivery_price = $('.order-container #order-details .order-item .delivery-price');

                cost = 0;

                /** update cost */
                for (var i = 0; i < list.length; i++) {
                    var priceItem = price[i].textContent;
                    var deliveryPriceItem = delivery_price[i].textContent;
                    priceItem = parseInt(quantity[i].value) * parseFloat(priceItem.substring(priceItem.indexOf('$') + 1, priceItem.length)) + parseFloat(deliveryPriceItem.substring(deliveryPriceItem.indexOf('$') + 1, deliveryPriceItem.length));

                    list[i].innerHTML = '$' + priceItem.toFixed(2);

                    cost += priceItem;
                }

                /** set the cost info */
                $('.order-container #final-order .real .value').html('$' + cost.toFixed(2));
            },

            /**
             * [updateCertainAddr: when another address is choosen, then change the certain addr in the bottom box ]
             * @return {[type]} [description]
             */
            updateCertainAddr = function() {
                var radio_list = $('.order-container #order-addr .addresses input[type="radio"]');
                var addr_list = $('.order-container #order-addr .addresses .address');
                var receiver_list = $('.order-container #order-addr .addresses .receiver .value');
                var phone_list = $('.order-container #order-addr .addresses .phone .value');
                for (var i = 0; i < radio_list.length; i++) {
                    if (radio_list[i].getAttribute('checked') == 'checked') {
                        /** addr */
                        $('.order-container #final-order .box .send .value').html(addr_list[i].getAttribute('title'));
                        /** receiver */
                        $('.order-container #final-order .box .receiver .value').html(receiver_list[i].innerHTML);
                        /** phone */
                        $('.order-container #final-order .box .phone .value').html(phone_list[i].innerHTML);
                    };
                }
            },

            /**
             * [changeRadio: change radio event]
             * @return {[type]} [description]
             */
            changeRadio = function() {
                /** clear checked */
                /** clear all the check attribute of input tags */
                var addr_list = $('.order-container #order-addr .addresses input[type="radio"]');
                for (var i = 0; i < addr_list.length; i++) {
                    addr_list[i].removeAttribute('checked');
                }
                /** set checked */
                $(this).attr('checked', 'checked');
                /** update addr info */
                updateCertainAddr();
            },

            /**
             * [getValue: get the value of an object and check whether it's empty]
             * @param  {[type]} object [description]
             * @return {[type]}        [description]
             */
            getValue = function(object) {
                var value = object.val();

                if (typeof(value) != 'undefined' && value == '') {
                    object.focus();
                    alert('please input the empty item');
                    return '';
                }
                return value;
            },

            /**
             * [initData: init cart data]
             * @param  {[type]} data [data from the interface]
             * @return {[type]}      [description]
             */
            initData = function(data) {
                /** parse */
                var cart = data.cart,
                    delivery_options = data.delivery_options,
                    origin_cost = 0,
                    right_cost = 0;

                for (var i in cart) {
                    /** calculate the cost */
                    origin_cost += parseInt(cart[i].quantity) * parseFloat(cart[i].origin_price);
                    right_cost += parseInt(cart[i].quantity) * parseFloat(cart[i].price);

                    /** generate delivery company options */
                    var company_options = '';
                    for (var j in delivery_options) {
                        company_options += '<option value="' + j + '">' + delivery_options[j].company_name + '</option>';
                    }

                    /** generate options of the first company */
                    var price_options = '';
                    for (var j in delivery_options[0].price_option) {
                        price_options += '<option value="' + delivery_options[0].price_option[j].value + '">' + delivery_options[0].price_option[j].description + '</option>';
                    }

                    /** append list item */
                    $('.order-container #order-details').append('<div class="order-item" item="' + i + '">\
                        <div class="pic-container">\
                            <a href="' + cart[i].shop_url + '" target="_blank">\
                                <div class="over">\
                                    <div class="link-btn"></div>\
                                </div>\
                            </a>\
                            <div class="shop" style="background-image: url(' + cart[i].shop_pic + ');"></div>\
                        </div>\
                        <div class="order-info">\
                            <span class="name">' + cart[i].name + '</span>\
                            <span class="size">' + cart[i].size + '</span>\
                            <span class="color" style="background-color: ' + cart[i].color + ';"></span>\
                        </div>\
                        <div class="order-origin-price">\
                            <s>$' + cart[i].origin_price + '</s><span>$' + cart[i].price + '</span>\
                        </div>\
                        <div class="quantity">\
                            <input type="number" name="quantity" min="1" value="' + cart[i].quantity + '">\
                        </div>\
                        <div class="order-delivery">\
                            <select item="' + i + '">\
                            ' + company_options + '\
                            </select>\
                        </div>\
                        <div class="order-delivery-price">\
                            <select>\
                                ' + price_options + '\
                            </select>\
                        </div>\
                        <div class="order-price">\
                            <p class="shop-price">$' + (parseInt(cart[i].quantity) * parseFloat(cart[i].price) + parseFloat(delivery_options[0].price_option[0].value)).toFixed(1) + '</p>\
                            <p class="delivery-price">+ $' + delivery_options[0].price_option[0].value + '</p>\
                        </div>\
                    </div>');
                }
            };

        /** get data by uid */
        $.ajax({
                url: 'cartInfo',
                type: 'post',
                dataType: 'json',
                data: {},
            })
            .done(function(data) {
                /** init the data of order */
                initData(data);
            })
            .fail(function() {
                console.log('failed to get order data');
            });

        /** update cost info */
        updateCost();

        /** update addr info */
        updateCertainAddr();

        /** [change function of changing delivery company ] */
        $('.order-container #order-details .order-delivery').change(function() {
            /** clear option */
            $(this).next().children('select').children('option').remove();

            /** index the item */
            var i = $(this).parent().attr('item');

            /** index the company item */
            var k = $(this).children('select').val();

            /** append the new option */
            var price_options = '';
            for (var j in delivery_options[0].price_option) {
                price_options += '<option value="' + delivery_options[k].price_option[j].value + '">' + delivery_options[k].price_option[j].description + '</option>';
            }
            $(this).next().children('select').append(price_options);

            $('.order-container #order-details .order-delivery-price').change();
        });

        /** [delivery price change] */
        $('.order-container #order-details .order-delivery-price').change(function() {
            /** @type {[type]} [the selected delivery price] */
            var selectPrice = parseFloat($(this).children('select').val());

            /** @type {[type]} [cost without delivery price] */
            var origin_cost = $(this).prev().prev().prev().children('span').html();
            origin_cost = parseFloat(origin_cost.substring(1, origin_cost.length));

            /** update cost of the item */
            $(this).next().children('.delivery-price').html('+ $' + selectPrice.toFixed(1));

            /** update cost info */
            updateCost();
        });

        /** [change function of quantity changing ] */
        $('.order-container #order-details .quantity input[type="number"]').change(function(event) {
            /** check legality when keydown */
            var regex = new RegExp("^[0-9]*[1-9][0-9]*$");
            if (regex.test($(this).val())) {
                if (parseInt($(this).val()) > 99) {
                    $(this).focus();
                    $(this).val(99);
                    alert('you can only enter integer number between 1 and 99');
                } else {
                    $(this).attr('value', $(this).val());
                }
            } else {
                $(this).focus();
                $(this).val(Math.abs(parseInt($(this).val())));
                alert('you can only enter integer number between 1 and 99');
            }

            updateCost();
        });

        /** [radio change] */
        $('.order-container #order-addr .addresses input[type="radio"]').change(changeRadio);

        /** [click function of other addr] */
        $('.order-container #order-addr .other').click(function(event) {
            /* Act on the event */
            /** initialize the map */
            $('.order-container #order-addr .addresses #other-addr-input .map').locationpicker({
                location: {
                    latitude: 34.123636,
                    longitude: 108.83636
                },
                radius: 10,
                inputBinding: {
                    locationNameInput: $('#add-addr')
                },
                enableAutocomplete: true
            });

            /** show the map */
            $('.order-container #order-addr .addresses #other-addr-input').show();
        });

        /** [click function of adding address] */
        $('.order-container #order-addr .addresses #other-addr-input a').click(function(event) {
            /* Act on the event */
            var otherAddr = getValue($('.order-container #order-addr .addresses #other-addr-input #add-addr'));

            /** [if: return when otherAddr is empty] */
            if (otherAddr == '') {
                return;
            }

            var receiver = getValue($('.order-container #order-addr .addresses #other-addr-input #receiver'));

            /** [if: return when receiver is empty] */
            if (receiver == '') {
                return;
            }

            var phone = getValue($('.order-container #order-addr .addresses #other-addr-input #phone'));

            /** [if: return when phone is empty] */
            if (phone == '') {
                return;
            }

            /** clear all the check attribute of input tags */
            var addr_list = $('.order-container #order-addr .addresses input[type="radio"]');
            for (var i = 0; i < addr_list.length; i++) {
                addr_list[i].removeAttribute('checked');
            }

            /**
             * [append div]
             */
            $('.order-container #order-addr .addresses').append('<div>\
                <label>\
                    <input type="radio" name="addr" checked="checked">\
                    <span class="address" title="' + otherAddr + '">' + otherAddr + '</span>\
                    <span class="receiver">\
                    <span class="name">receiver name: </span>\
                    <span class="value">' + receiver + '</span>\
                    </span>\
                    <span class="phone">\
                    <span class="name">phone number: </span>\
                    <span class="value">' + phone + '</span>\
                    </span>\
                </label>\
            </div>');

            /** rebinding the radio change */
            /** [unbind] */
            $('.order-container #order-addr .addresses input[type="radio"]').unbind('change');
            /** [radio change] */
            $('.order-container #order-addr .addresses input[type="radio"]').change(changeRadio);

            /** hide the map */
            $('.order-container #order-addr .addresses #other-addr-input').hide();

            /** update addr info */
            updateCertainAddr();
        });
    },

    initShow: function() {
        "use strict";
    },

    initList: function() {
        "use strict";

        /** date object */
        var date = new Date();

        /** get data by uid and page */
        $.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data: {
                    uid: '',
                    page: 0
                },
            })
            .done(function() {})
            .fail(function() {})
            .always(function() {
                console.log("get cart data complete");
            });

        /** test data */
        var testData = "{\n\t\"uid\": \"123\",\n\t\"count\": 2,\n\t\"page\": 1,\n\t\"orderDatas\": [\n\t\t{\n\t\t\t\"oid\": \"12341544234\",\n\t\t\t\"ctime\": \"1446692400\",\n\t\t\t\"order\": [\n\t\t\t\t{\n\t\t\t\t\t\"sid\" : \"1\",\n\t\t\t\t\t\"name\": \"shop1\",\n\t\t\t\t\t\"size\": \"S\",\n\t\t\t\t\t\"origin_price\": \"38.9\",\n\t\t\t\t\t\"price\": \"28.9\",\n\t\t\t\t\t\"quantity\": 2,\n\t\t\t\t\t\"color\": \"#000000\",\n\t\t\t\t\t\"shop_url\": \"\",\n\t\t\t\t\t\"shop_pic\": \".\/images\/shops\/shop1.jpg\",\n\t\t\t\t\t\"delivery_price\": \"10.0\"\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"sid\" : \"2\",\n\t\t\t\t\t\"name\": \"shop2\",\n\t\t\t\t\t\"size\": \"XL\",\n\t\t\t\t\t\"origin_price\": \"29.9\",\n\t\t\t\t\t\"price\": \"25.9\",\n\t\t\t\t\t\"quantity\": 1,\n\t\t\t\t\t\"color\": \"#232122\",\n\t\t\t\t\t\"shop_url\": \"\",\n\t\t\t\t\t\"shop_pic\": \".\/images\/shops\/shop2.jpg\",\n\t\t\t\t\t\"delivery_price\": \"10.8\"\n\t\t\t\t}\n\t\t\t]\t\t\n\t\t},\n\t\t{\n\t\t\t\"oid\": \"12341241323\",\n\t\t\t\"ctime\":  \"1417751768\",\n\t\t\t\"order\": [\n\t\t\t\t{\n\t\t\t\t\t\"sid\" : \"4\",\n\t\t\t\t\t\"name\": \"shop4\",\n\t\t\t\t\t\"size\": \"L\",\n\t\t\t\t\t\"origin_price\": \"30.9\",\n\t\t\t\t\t\"price\": \"25.9\",\n\t\t\t\t\t\"quantity\": 1,\n\t\t\t\t\t\"color\": \"#3f205c\",\n\t\t\t\t\t\"shop_url\": \"\",\n\t\t\t\t\t\"shop_pic\": \".\/images\/shops\/shop4.jpg\",\n\t\t\t\t\t\"delivery_price\": \"11.8\"\n\t\t\t\t}\n\t\t\t]\n\t\t}\n\t]\n}";

        /** parse */
        var orders = JSON.parse(testData);

        /** [for: append] */
        for (var i in orders.orderDatas) {
            /** loop to get shop item for this order */
            var shopItem = '';

            /** order time */
            date.setTime(orders.orderDatas[i].ctime * 1000);
            for (var j in orders.orderDatas[i].order) {
                shopItem += '<div class="shop-item">\
                    <div class="pic-container">\
                        <a href="' + orders.orderDatas[i].order[j].shop_url + '" target="_blank">\
                            <div class="over">\
                                <div class="link-btn"></div>\
                            </div>\
                        </a>\
                    <div class="shop" style="background-image: url(' + orders.orderDatas[i].order[j].shop_pic + ');"></div>\
                    </div>\
                    <div class="color" style="background-color: ' + orders.orderDatas[i].order[j].color + '"></div>\
                    <div class="origin-price">\
                        <p class="origin">\
                            <s>$' + orders.orderDatas[i].order[j].origin_price + '</s>\
                        </p>\
                        <p class="current">$' + orders.orderDatas[i].order[j].price + '</p>\
                    </div>\
                    <div class="quantity">\
                        <p class="value">' + orders.orderDatas[i].order[j].quantity + '</p>\
                        <p class="name">quantity</p>\
                    </div>\
                    <div class="size">\
                        <p class="value">' + orders.orderDatas[i].order[j].size + '</p>\
                        <p class="name">size</p>\
                    </div>\
                    <div class="price">\
                        <p class="shop-price">\
                            $' + (parseInt(orders.orderDatas[i].order[j].quantity) * parseFloat(orders.orderDatas[i].order[j].price) + parseFloat(orders.orderDatas[i].order[j].delivery_price)) + '\
                        </p>\
                        <p class="delivery-price">delivery price: + $' + orders.orderDatas[i].order[j].delivery_price + '</p>\
                    </div>\
                    <div class="info">\
                        <div class="delivery-status">\
                            <p class="value">delivering</p>\
                            <p class="name">delivery status</p>\
                            <p><a class="value" href="#">details</a></p>\
                            <p class="name">more details</p>\
                            <p><a class="value" href="#">track the delivery</a></p>\
                            <p class="name">track where the shop is</p>\
                        </div>\
                    </div>\
                    <div class="handle-btn button">Deal</div>\
                </div>';
            }

            $('.order-container #order-list').append('<div class="order-item">\
                <div class="brief-info">\
                    <div class="order-id">\
                        <span class="name">order id:</span>\
                        <span class="value">' + orders.orderDatas[i].oid + '</span>\
                    </div>\
                    <div class="order-ctime">\
                        <span class="value"> ' + date.format('yyyy-MM-dd hh:mm:ss') + ' </span>\
                    </div>\
                    <div class="delete-btn button"></div>\
                </div>' + shopItem + '</div>');
        }

        /** [click function of delete order] */
        $('.order-container #order-list .order-item .delete-btn').click(function(event) {


            /** remove dom node */
            $(this).parent().parent().remove();
        })
    }
};
