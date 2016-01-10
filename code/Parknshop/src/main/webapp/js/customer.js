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
 *      - Update Time: Jan 9, 2015 
 *
 *
 **********************************************************************/
"use strict";
/** Date format */
Date.prototype.format = function (format) {
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

String.prototype.replaceAll = function (reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
}


var customer = {
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
     * [init: init common parts]
     * @return {[type]} [description]
     */
    init: function () {
        "use strict";
        var scrollController = this.scrollController;
        /** [click function of the black button] */
        $('.back-btn').click(function () {
            history.go(-1);
        });

        $('.scroll').hover(function () {
            scrollController.disableScroll($(document.body));
        }, function () {
            scrollController.enableScroll($(document.body));
        });

        /** init the dialog */
        this.initDialog();

        /** disable enter key keydown */
        $(document).on("keydown", function (event) {
            var userAgent = navigator.userAgent.toLowerCase();
            var keycode;
            if (userAgent.indexOf('firefox') >= 0 || userAgent.indexOf('ie') >= 0) {
                keycode = event.which;
            } else {
                var ev = (event === undefined) ? window.event : event;
                keycode = ev.keyCode;
            }

            if (keycode === 13 && document.activeElement.id === "add-to-cart") {
                return false;
            }
        });
    },

    /**
     * [initRegister: init some events of the register page]
     * @return {[type]} [description]
     */
    initRegister: function () {
    	function changeRadio() {
                /** clear checked */
                /** clear all the check attribute of input tags */
                const radioLists = $('.register-area input[type="radio"]');
                for (let i = 0; i < radioLists.length; i++) {
                    radioLists[i].removeAttribute('checked');
                }

                /** set checked */
                $(this).attr('checked', 'checked');
            }

    	// $('.register-area input[type="radio"]').change(changeRadio);
    },

    initIndex: function () {
        "use strict";
        const swiper = new Swiper('.swiper-container', {
            pagination: '.swiper-pagination',
            paginationClickable: true,
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',
            spaceBetween: 0,
            loop: true,
            autoplay: 5000,
            autoplayDisableOnInteraction: false
        });

        $('.index-container .categories .products-btn').click(function () {
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
     * [initDialog: init the part, dialog]
     * @return {[type]} [description]
     */
    initDialog: function () {
        "use strict";
        /**
         * [stateMacine: the state machine of the operations]
         * @type {String}
         */
        const stateMachine = {
            'main': '',
            'add-friend-main': 'main',
            'people-list-main': 'add-friend-main',
            'certain-add-main': 'people-list-main',
            'certain-delete-main': 'main',
            'notice-add-main': 'people-list-main',
            'notice-del-main': 'main'
        };

        /**
         * [lastStep: to store the last operation]
         * @type {String}
         */
        let lastStep = '';

        /**
         * [cometArrays: the array to store each comet object for each name]
         * @type {Array}
         */
        let cometArrays = [];

        /**
         * [updateArrays: the array to store the number when update the messages]
         * @type {Array}
         */
        let updateArrays = [];

        /**
         * [showPart: show the part and hide others]
         * @param  {[type]} part [the part you want to show]
         * @return {[type]}      [description]
         */
        function showPart(part) {
            $('#somedialog .dialog__content').hide();
            $('#somedialog .dialog__content').removeClass('shown');

            $('#somedialog #' + part).show();
            $('#somedialog #' + part).addClass('shown');

            /** set the last step of this page */
            lastStep = stateMachine[part];
        }

        /**
         * [updateFriendList: update the friends list]
         * @param  {[type]} name [if the name is not null, then choose the name first]
         * @return {[type]}      [description]
         */
        function updateFriendList(name) {
            /** name is null by default */
            name = name || null;

            $.ajax({
                    url: 'friends',
                    type: 'POST',
                    dataType: 'json',
                    data: {},
                })
                .done(function (data) {
                    /** clear all friends first */
                    for (var i = 0; i < $('.dialog #main .friend-list .list ul').children().length; i++) {
                        $('.dialog #main .friend-list .list ul').children(i).remove();
                    }

                    /**
                     * [for: release all comet objects, and clear all numbers]
                     */
                    for (let i = 0; i < cometArrays.length; i++) {
                        cometArrays[i].release();
                    }
                    cometArrays = [];
                    updateArrays = [];

                    /** append */
                    if (typeof(data.friends) != 'undefined') {
                        for (let j = 0; j < data.friends.length; j++) {
                            updateArrays.push(0);
                            /** [if: first child] */
                            if (j == 0) {
                                $('.dialog #main .friend-list .list ul').append('<li class="select button" uid="' + data.friends[j].uid + '">' + data.friends[j].name + '</li>');
                                $('#friendNameBlock').html(data.friends[j].name);
                                /** get the message of choosen name */
                                getMessage(data.friends[j].name, true);
                            } else {
                                if (data.friends[j].name == name) {
                                    /** remove the select class */
                                    $('.dialog #main .friend-list .list ul').children(0).removeClass('select');

                                    $('.dialog #main .friend-list .list ul').append('<li class="select button" uid="' + data.friends[j].uid + '">' + data.friends[j].name + '</li>');

                                    /** get the message of choosen name */
                                    getMessage(data.friends[j].name, true);
                                } else {
                                    $('.dialog #main .friend-list .list ul').append('<li class="button" uid="' + data.friends[j].uid + '">' + data.friends[j].name + '</li>');
                                }
                            }
                        }

                        /** [click function of choosing friends] */
                        $('.dialog #main .friend-list .list ul > li').click(function () {
                            /** [remove the original selected item] */
                            $(this).parent().children('li').each(function () {
                                $(this).removeClass('select');
                            });

                            /** [set the new selected item] */
                            $(this).addClass('select');
                            getMessage($(this).html(), false);
                            $('#friendNameBlock').html($(this).html());
                            $(this).children('span').remove();
                        });
                    }

                })
                .fail(function () {
                    console.log("failed to get friends list");
                });
        }

        /**
         * [getMessage: get message from the friend]
         * @param  {[type]} friendName [the name of the friend]
         * @param  {[type]} isComet       [the name of the friend]
         * @return {[type]}            [description]
         */
        function getMessage(friendName, isComet) {
            const postData = {
                friendName: friendName
            };

            $.ajax({
                    url: 'messages',
                    type: 'POST',
                    dataType: 'json',
                    data: postData
                })
                .done(function (data) {
                    if (typeof(data.messages) != 'undefined') {
                        $('.dialog #main .dialog-show').children('p').remove();
                        for (let i = 0; i < data.messages.length; i++) {
                            /** date object */
                            let date = new Date();
                            let isRight = '';
                            let userName = friendName;

                            date.setTime(data.messages[i].messageTime.time);

                            if (data.userId !== data.messages[i].friendId) {
                                isRight = 'right';
                                userName = 'me';
                            }

                            $('.dialog #main .dialog-show').append('<p class="time ' + isRight + '">' + userName + ': ' + date.format('yyyy-MM-dd hh:mm') + '</p>\
                            <p class="' + isRight + '">' + data.messages[i].content + '</p>');
                        }

                        updateArrays[friendName] = data.messages.length;

                        /** keep in the bottom */
                        $('.dialog #main #dialog-show').scrollTop(parseFloat(document.getElementById('dialog-show').scrollHeight));
                    } else {
                        console.log("failed to get message, but post succeed");
                    }

                    if (isComet) {
                        const cometObj = Object.create(Comet);
                        cometObj.init('messages');
                        cometObj.subscribe(postData, function () {
                            const $list = $('.dialog .list ul').children('li');
                            $list.each(function () {
                                if ($(this).html() === friendName) {
                                    $(this).append('<span></span>');
                                    return;
                                }
                            });
                        });
                        cometArrays.push(cometObj);
                        cometObj.run(updateArrays[friendName]);
                    }
                })
                .fail(function () {
                    console.log('failed to get message');
                });
        }

        /**
         * [sendMessage: send messages to someone]
         * @param  {[type]} name    [the name]
         * @param  {[type]} content [the content you want to send]
         * @return {[type]}         [description]
         */
        function sendMessage(name, content) {
            $.ajax({
                    url: 'leaveMsg',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        friendName: name,
                        content: content
                    },
                })
                .done(function (data) {
                    if (data.success) {
                        let date = new Date();

                        /** apeend */
                        $('.dialog #main .dialog-show').append('<p class="time right">me: ' + date.format('yyyy-MM-dd hh:mm') + '</p>\
                                <p class="right">' + content + '</p>');

                        /** keep in the bottom */
                        $('.dialog #main #dialog-show').scrollTop(parseFloat(document.getElementById('dialog-show').scrollHeight));

                        /** clear textarea */
                        $('.dialog #main .dialog-input textarea').val('');
                    } else {
                        console.log("failed to send a message, but post succeed");
                    }
                })
                .fail(function () {
                    console.log("failed to send a message");
                });
        }

        /**
         * [searchFriends: search friends by the name]
         * @param  {[type]} name [the name]
         * @return {[type]}      [description]
         */
        function searchFriends(name) {
            $.ajax({
                    url: 'searchUser',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        name: name
                    },
                })
                .done(function (data) {
                    if (typeof(data.users) != 'undefined') {
                        /** clear children */
                        for (let i = 0; i < $('.dialog #people-list-main .list ul').children().length; i++) {
                            $('.dialog #people-list-main .list ul').children(i).remove();
                        }

                        /** append */
                        for (let j = 0; j < data.users.length; j++) {
                            /** [if: first child] */
                            if (j == 0) {
                                $('.dialog #people-list-main .list ul').append('<li class="select button">' + data.users[j] + '</li>')
                            } else {
                                $('.dialog #people-list-main .list ul').append('<li class="button">' + data.users[j] + '</li>')
                            }
                        }

                        /** [click function of choosing people to add] */
                        $('.dialog #people-list-main .list ul > li').click(function () {
                            /** [remove the original selected item] */
                            $(this).parent().children('li').each(function () {
                                $(this).removeClass('select');
                            });

                            /** [set the new selected item] */
                            $(this).addClass('select');
                        });
                    } else {
                        console.log("failed to search friends, but post succeed");
                    }
                })
                .fail(function () {
                    console.log("failed to search friends");
                });
        }

        /**
         * [addFriend: add friend by the name]
         * @param {[type]} name [the name]
         */
        function addFriend(name) {
            $.ajax({
                    url: 'addFriend',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        friendName: name
                    },
                })
                .done(function (data) {
                    if (data.success) {
                        updateFriendList(name);
                    } else {
                        updateFriendList(name);
                        alert('you have added this as a friend');
                        console.log("failed to add the friend, but post succeed");
                    }
                    showPart('main');
                })
                .fail(function () {
                    console.log("failed to add the friend");
                });
        }

        /**
         * [delFriend: delete friend by the name]
         * @param  {[type]} name [the name]
         * @return {[type]}      [description]
         */
        function delFriend(name) {
            $.ajax({
                    url: 'deleteFriend',
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        friendName: name
                    },
                })
                .done(function (data) {
                    if (data.success) {
                        updateFriendList();
                    } else {
                        updateFriendList();
                        alert('failed to delete your friend');
                        console.log("failed to delete the friend, but post succeed");
                    }
                    showPart('main');

                    /** clear the message area */
                    $('.dialog #main .dialog-show').children('p').remove();
                })
                .fail(function () {
                    console.log("failed to delete the friend");
                });
        }

        /**
         * [handleSend: the handle function of sending messages]
         * @return {[type]} [description]
         */
        function handleSend() {
            if ($('.dialog #main .friend-list .list ul .select').length > 0) {
                if ($('.dialog #main .dialog-input textarea').val() == '') {
                    $('.dialog #main .dialog-input textarea').focus();
                    $('.dialog #main .dialog-input textarea').attr('placeholder', 'You cannot leave a empty message.');
                } else {
                    var content = $('.dialog #main .dialog-input textarea').val().replaceAll('\n', '<br />');
                    sendMessage($('.dialog #main .friend-list .list ul .select').html(), content);
                }
            } else {
                showPart('notice-del-main');
            }
        }

        /**
         * [init: init the animation trigger of the dialog]
         * @return {[type]} [description]
         */
        function init() {
            const dlgtrigger = document.querySelector('[data-dialog]');
            if (dlgtrigger) {
                const somedialog = document.getElementById(dlgtrigger.getAttribute('data-dialog'));
                let dlg = new DialogFx(somedialog);
                dlgtrigger.addEventListener('click', dlg.toggle.bind(dlg));
            }
        }

        /**
         * [initEvent: init all events of the dialog]
         * @return {[type]} [description]
         */
        function initEvent() {
            /** focus function or blur function of the search box input */
            $('.dialog #add-friend-main .search-box input[type="text"]').focus(function () {
                $(this).attr('placeholder', '');
            }).blur(function () {
                $(this).attr('placeholder', 'search...');
            });

            /** [click function of sending message button] */
            $('.dialog #main .dialog-input .send-btn').click(function (event) {
                /* Act on the event */
                handleSend();
            });

            /** [keydown function of sending message button] */
            $(document).on("keydown", function (event) {
                var userAgent = navigator.userAgent.toLowerCase();
                var keycode, ctrl;
                if (userAgent.indexOf('firefox') >= 0 || userAgent.indexOf('ie') >= 0) {
                    keycode = event.which;
                    ctrl = event.ctrlKey;
                } else {
                    var ev = (event === undefined) ? window.event : event;
                    keycode = ev.keyCode;
                    ctrl = ev.ctrlKey;
                }
                if (keycode === 13 && ctrl && document.activeElement.id === "message_textarea") {
                    handleSend();
                }
            });

            /** [click function of add friend button] */
            $('.dialog #main .bottom-buttons .add-friend-btn').click(function () {
                showPart('add-friend-main');
            });

            /** [click function of search button on the add friend page] */
            $('.dialog #add-friend-main .search-btn').click(function () {
                showPart('people-list-main');

                /** search friends */
                searchFriends($('.dialog #add-friend-main .search-box input[type="text"]').val());
            });

            /** [click function of certaining to add friends] */
            $('.dialog #people-list-main .bottom-buttons .certain-btn').click(function (event) {
                /* Act on the event */
                if ($('.dialog #people-list-main .list ul .select').length > 0) {
                    showPart('certain-add-main');
                } else {
                    showPart('notice-add-main');
                }
            });

            /** [click function of certaining] */
            $('.dialog #certain-add-main .bottom-buttons .certain-btn').click(function (event) {
                /* Act on the event */
                addFriend($('.dialog #people-list-main .list ul .select').html());
            });

            /** [click function of certaining to delete friends] */
            $('.dialog #main .bottom-buttons .del-friend-btn').click(function () {
                if ($('.dialog #main .friend-list .list ul .select').length > 0) {
                    showPart('certain-delete-main');
                } else {
                    showPart('notice-del-main');
                }
            });

            /** [click function of certaining] */
            $('.dialog #certain-delete-main .bottom-buttons .certain-btn').click(function (event) {
                /* Act on the event */
                delFriend($('.dialog #main .friend-list .list ul .select').html());
            });

            /** [click function of the dialog-back-btn] */
            $('.dialog .dialog-back-btn').click(function () {
                showPart(lastStep);
            })

            /** [go back when cancel] */
            $('.dialog .bottom-buttons .cancel-btn').click(function () {
                showPart(lastStep);
            })

            /** [check hover of communication button] */
            $('#communicate-btn').hover(function () {
                $(this).css('width', '120px');
            }, function () {
                $(this).css('width', '30px');
            })
        }

        /** init the animation */
        init();

        /** show main first */
        showPart('main');

        /** update friends list */
        updateFriendList();

        /** init all events */
        initEvent();
    },

    /**
     * [initRate: init the part, rate]
     * @return {[type]} [description]
     */
    initRate: function () {
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
            onClick: function (clickScore, data) {
                //Your function & post action
                /** get the rate option */
                var json = JSON.parse(data);
                var option = json.option;
                /** set the rate score */
                $('#' + option + '_rate').val(clickScore);
                /** set the score to show */
                $('.order-container #order-info .shop-rate .' + option + ' .rate-val').html(parseFloat(clickScore).toFixed(1));
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
    initCart: function () {
        "use strict";
        var origin_cost, right_cost;
        /**
         * [updateCost: update cost info]
         * @return {[type]} [description]
         */
        var updateCost = function () {
                var list = $('.cart-container #shop-lists .shop-item');
                var origin_list = $('.cart-container #shop-lists .shop-info .price .value .origin-cost');
                var right_list = $('.cart-container #shop-lists .shop-info .price .value .right-cost');
                var quantity_list = $('.cart-container #shop-lists .shop-info .quantity .value input');
                origin_cost = right_cost = 0;

                var j = 0;
                /** update cost */
                for (var i = 0; i < list.length; i++) {
                    /** continue the expired one */
                    if (list[i].getAttribute('class').indexOf('expired') >= 0 || list[i].getAttribute('class').indexOf('lack') >= 0) {
                        continue;
                    }

                    /** count the unexpired one */
                    j++;
                    origin_cost += parseInt(quantity_list[i].value) * parseFloat(origin_list[i].textContent.substring(1, origin_list[i].textContent.length));
                    right_cost += parseInt(quantity_list[i].value) * parseFloat(right_list[i].textContent.substring(1, right_list[i].textContent.length));
                }
                /** update quantity */
                $('#shop-cost .quantity .value').html(j);

                $('#shop-cost .origin .value').html('<s>$' + origin_cost.toFixed(1) + '</s>');
                $('#shop-cost .cost .value').html('$' + right_cost.toFixed(1));
            },

            /**
             * [initData: init cart data]
             * @param  {[type]} data [data from the interface]
             * @return {[type]}      [description]
             */
            initData = function (data) {
                /** parse */
                var cart = data.cart,
                    expired,
                    input;
                for (var i in cart) {
                    expired = input = '';
                    if (cart[i].expired == 'true') {
                        expired = 'expired';
                        input = 'disabled';
                    }
                    
                    if (cart[i].stock == 0) {
                    	expired = 'lack';
                    	input = 'disabled';
                    }
                    /** append list item */
                    $('.cart-container #shop-lists').append('<div class="' + expired + ' shop-item">\
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
                                    <input type="number" sid="' + cart[i].sid + '" min="1" ' + input + ' max_quantity="' + cart[i].stock + '" value="' + cart[i].quantity + '">\
                                </span>\
                            </div>\
                            <div class="color sub-main">\
                                <span>color</span>\
                                <span class="value" style="background-color: ' + cart[i].color + ';"></span>\
                            </div>\
                            <div class="status">' + expired + '</div>\
                            <div class="delete sub-main">\
                                <span class="value button"></span>\
                            </div>\
                        </div>\
                    </div>');
                }
            },

            /**
             * [initEvent: init all events]
             * @return {[type]} [description]
             */
            initEvent = function () {
                /** delete shop item */
                $('.cart-container #shop-lists .shop-item .shop-info .delete .value').click(function () {
                    var _this = $(this);
                    /** store data into database */
                    $.getJSON('deleteCart', {
                        sid: $(this).parent().prev().prev().prev().children('.value').children('input').attr('sid')
                    }, function (data, textStatus) {
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
                $('.cart-container #shop-cost .pay .value').click(function () {
                    window.location.href = "./order?type=certain";
                });

                /** [change function of quantity changing] */
                $('.cart-container #shop-lists .shop-info .quantity .value input[type="number"]').change(function (event) {
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
                            }, function (data, textStatus) {
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
            .done(function (data) {
                /** init the data of cart */
                initData(data);

                /** update cost info at the beginning */
                updateCost();

                /** init all events */
                initEvent();
            })
            .fail(function () {
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
     * @param  {[type]} oid       [the order id]
     * @param  {[type]} productId [the product id]
     * @param  {[type]} itemId    [the item id]
     * @return {[type]}           [description]
     */
    initComment: function (oid, productId, item) {
        "use strict";
        function initData(data) {
            /** @type {Date} [date object] */
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

            $('.order-container #order-info .shop-info').append('<div class="pic-container">\
                    <a href="' + data.orderInfos[item].productUrl + '" target="_blank">\
                        <div class="over">\
                            <div class="link-btn"></div>\
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
                        <span class="name">Shop Owner</span>\
                        <span class="value">' + data.orderInfos[item].product.shop.name + '</span>\
                    </div>\
                    <div class="address item">\
                        <span class="name">Address</span>\
                        <span class="value">' + data.address.description + '</span>\
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
                </div>')
        }
        
        /** init the rate system */
        this.initRate();

        /** check whether pay or not */
        $.getJSON('orderByType', {
            type: 'show',
            oid: oid
        }, function (data, textStatus) {
            /*optional stuff to do after success */
            const productId = $('#productId').val();

            initData(data);

            for (let i = 0; i < data.orderInfos.length; i++) {
                if (data.orderInfos[i].productId == productId && data.orderInfos[i].status !== 'dealed') {
                    $('.order-container #order-info .comment-submit').css({
                        'border': '2px solid #e0e0e0',
                        'background-color': '#f0f0f0',
                        'color': '#e0e0e0'
                    });
                    return;
                }
            }

            $('.order-container #order-info .comment-submit').click(function () {
            	if ($('#commentContent').val() === '') {
            		$('#commentContent').focus();
            		alert('fill the empty comment');
            	} else {
            		$.getJSON('comment', {
            			orderId: oid,
                        productId: $('#productId').val(),
                        content: $('#commentContent').val(),
                        shopScore: $('#shop_rate').val(),
                        productScore: $('#product_rate').val(),
                        deliveryScore: $('#delivery_rate').val()
                    }, function (data, textStatus) {
                        /*optional stuff to do after success */
                        if (data.success) {
                            $('.order-container #order-info .comment-submit').css({
                                'border': '2px solid #e0e0e0',
                                'background-color': '#f0f0f0',
                                'color': '#e0e0e0'
                            });

                            $('.order-container #pay-btn').removeClass('button');

                            $('.order-container #pay-btn').unbind('click');
                        } else {
                            alert('Ooops, failed to comment');
                        }
                    });
            	}
            });
        });
    },

    /**
     * [initCertain: init the page certain]
     * @return {[type]} [description]
     */
    initCertain: function () {
        "use strict";
        var cost, cart, delivery_options, address_id = null;
        /**
         * [updateCost: update cost info]
         * @return {[type]} [description]
         */
        var updateCost = function () {
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

                    list[i].setAttribute('title', '$' + priceItem.toFixed(2));
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
            updateCertainAddr = function () {
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
            changeRadio = function () {
                /** clear checked */
                /** clear all the check attribute of input tags */
                var addr_list = $('.order-container #order-addr .addresses input[type="radio"]');
                for (var i = 0; i < addr_list.length; i++) {
                    addr_list[i].removeAttribute('checked');
                }
                /** set checked */
                $(this).attr('checked', 'checked');

                address_id = $(this).attr('aid');

                /** update addr info */
                updateCertainAddr();
            },

            /**
             * [getValue: get the value of an object and check whether it's empty]
             * @param  {[type]} object [description]
             * @return {[type]}        [description]
             */
            getValue = function (object) {
                var value = object.val();

                if (typeof(value) != 'undefined' && value == '') {
                    object.focus();
                    alert('please input the empty item');
                    return '';
                }
                return value;
            },

            /**
             * [initAddr: init the addr options]
             * @return {[type]} [description]
             */
            initAddr = function () {
                /** get addrs data */
                $.ajax({
                        url: 'showAddress',
                        type: 'POST',
                        dataType: 'json',
                        data: {},
                    })
                    .done(function (data) {
                        var checked = '';
                        for (var i in data.addresses) {
                            /** [if: choose the first item] */
                            if (i == 0) {
                                checked = 'checked="checked"';
                                address_id = data.addresses[i].a_id;
                            } else {
                                checked = '';
                            }

                            /** append div */
                            $('.order-container #order-addr .addresses').prepend('<div>\
                            <label>\
                                <input type="radio" aid="' + data.addresses[i].a_id + '" name="addr" ' + checked + '>\
                                <span class="address" title="' + data.addresses[i].description + '"> ' + data.addresses[i].description + '</span>\
                                <span class="receiver">\
                                <span class="name">receiver name: </span>\
                                <span class="value">' + data.addresses[i].name + '</span>\
                                </span>\
                                <span class="phone">\
                                <span class="name">phone number: </span>\
                                <span class="value">' + data.addresses[i].phone + '</span>\
                                </span>\
                            </label>\
                        </div>');
                        }

                        /** [radio change] */
                        $('.order-container #order-addr .addresses input[type="radio"]').change(changeRadio);

                        /** update addr info */
                        updateCertainAddr();
                    })
                    .fail(function () {
                        console.log("failed to get addr options");
                    });
            },

            /**
             * [addAddr: add an addr option]
             * @param {[type]} addr     [the description of the addr]
             * @param {[type]} receiver [the receiver name]
             * @param {[type]} phone    [the phone number]
             */
            addAddr = function (addr, receiver, phone) {
                $.ajax({
                        url: 'addAddress',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            description: addr,
                            zipcode: '000000',
                            name: receiver,
                            phone: phone
                        },
                    })
                    .done(function (data) {
                        if (data.result === 'false') {
                            alert('failed to add a new addr');
                        } else {
                            /**
                             * [append div]
                             */
                            $('.order-container #order-addr .addresses').prepend('<div>\
                                    <label>\
                                        <input type="radio" name="addr" checked="checked">\
                                        <span class="address" title="' + addr + '">' + addr + '</span>\
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

                            /** update address_id */
                            address_id = data.addressId;
                        }
                    })
                    .fail(function () {
                        console.log("failed to add an addr");
                    });
            },

            /**
             * [initEvent: init all events]
             * @return {[type]} [description]
             */
            initEvent = function () {
                /** [change function of changing delivery company ] */
                $('.order-container #order-details .order-delivery').change(function () {
                    /** clear option */
                    $(this).next().children('select').children('option').remove();

                    /** index the item */
                    var i = $(this).parent().attr('item');

                    /** index the company item */
                    var k = $(this).children('select').val();

                    /** append the new option */
                    var price_options = '';
                    for (var j in delivery_options[0].price_option) {
                        price_options += '<option value="' + delivery_options[k].price_option[j].value + '" delivery_id="' + delivery_options[k].price_option[j].delivery_id + '">' + delivery_options[k].price_option[j].description + '</option>';
                    }
                    $(this).next().children('select').append(price_options);

                    $('.order-container #order-details .order-delivery-price').change();
                });

                /** [delivery price change] */
                $('.order-container #order-details .order-delivery-price').change(function () {
                    /** @type {[type]} [the selected delivery price] */
                    var selectPrice = parseFloat($(this).children('select').val());

                    /** @type {[type]} [cost without delivery price] */
                    var origin_cost = $(this).prev().prev().prev().children('span').html();
                    origin_cost = parseFloat(origin_cost.substring(1, origin_cost.length));

                    /** update cost of the item */
                    $(this).next().children('.delivery-price').html('+ $' + selectPrice.toFixed(1));

                    /** update cost info */
                    updateCost();

                    /** update delivery_id */
                    var index = $(this).children('select')[0].selectedIndex;
                    $(this).parent()[0].setAttribute('delivery_id', $(this).children('select').children('option')[index].getAttribute('delivery_id'))
                });

                /** [change function of quantity changing ] */
                $('.order-container #order-details .quantity input[type="number"]').change(function (event) {
                    /** check legality when keydown */
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
                            }, function (data, textStatus) {
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

                /** [click function of other addr] */
                $('.order-container #order-addr .other').click(function (event) {
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
                $('.order-container #order-addr .addresses #other-addr-input a').click(function (event) {
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

                    addAddr(otherAddr, receiver, phone);
                });

                /** [click function of submitting the order] */
                $('.order-container #final-order .box .submit-btn').click(function (event) {
                    /* Act on the event */
                    var productLists = $('.order-container #order-details .order-item');

                    var orders = [];

                    for (var i = 0; i < productLists.length; i++) {
                        orders[i] = {
                            product_id: productLists[i].getAttribute('sid'),
                            delivery_id: productLists[i].getAttribute('delivery_id')
                        };
                    }

                    if (address_id == null) {
                        alert('please add an address for your own first');
                        $('.order-container #order-addr .other').click();
                    } else {
                        if (orders.length === 0) {
                            alert('you have no produts');
                        } else {
                            $.getJSON('addOrder', {
                                address_id: address_id,
                                options: orders
                            }, function (data, textStatus) {
                                /*optional stuff to do after success */
                                if (data.result == 'true') {
                                	window.location.href = '?type=pay&oid=' + data.oid;
                                } else {
                                	alert('failed to create an order');
                                }
                            });
                        }
                    }
                });
            },

            /**
             * [initData: init cart data]
             * @param  {[type]} data [data from the interface]
             * @return {[type]}      [description]
             */
            initData = function (data) {
                /** parse */
                cart = data.cart;
                delivery_options = data.delivery_options;
                var origin_cost = 0,
                    right_cost = 0;

                for (var i in cart) {
                    /** continue expired one */
                    if (cart[i].expired == 'true' || cart[i].stock == 0) {
                        continue;
                    }
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
                        price_options += '<option value="' + delivery_options[0].price_option[j].value + '" delivery_id="' + delivery_options[0].price_option[j].delivery_id + '">' + delivery_options[0].price_option[j].description + '</option>';
                    }

                    /** append list item */
                    $('.order-container #order-details').append('<div class="order-item" item="' + i + '" sid="' + cart[i].sid + '" delivery_id="' + delivery_options[0].price_option[0].delivery_id + '">\
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
                            <s title="$' + cart[i].origin_price + '">$' + cart[i].origin_price + '</s><span title="$' + cart[i].price + '">$' + cart[i].price + '</span>\
                        </div>\
                        <div class="quantity">\
                            <input type="number" sid="' + cart[i].sid + '" min="1" max_quantity="' + cart[i].stock + '" value="' + cart[i].quantity + '">\
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
                            <p class="shop-price" title="$' + (parseInt(cart[i].quantity) * parseFloat(cart[i].price) + parseFloat(delivery_options[0].price_option[0].value)).toFixed(1) + '">$' + (parseInt(cart[i].quantity) * parseFloat(cart[i].price) + parseFloat(delivery_options[0].price_option[0].value)).toFixed(1) + '</p>\
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
            .done(function (data) {
                /** init the data of order */
                initData(data);

                /** init the data of address */
                initAddr();

                /** init all events */
                initEvent();

                /** update cost info */
                updateCost();
            })
            .fail(function () {
                console.log('failed to get order data');
            });
    },

    initShow: function (oid, item) {
        "use strict";
        /**
         * [initData: init the data of the item of the order]
         * @param  {[type]} data [description]
         * @return {[type]}      [description]
         */
        const initData = function (data) {
            const operations = {
                '': {
                    name: '',
                    nextStep: '',
                    disabled: 'disabled'
                },
                unpaid: {
                    name: 'Pay',
                    nextStep: 'pay',
                    disabled: ''
                },
                paid: {
                    name: 'Wait',
                    nextStep: '',
                    disabled: 'disabled'
                },
                delivering: {
                    name: 'Deal',
                    nextStep: 'deal',
                    disabled: ''
                },
                dealed: {
                    name: 'Comment',
                    nextStep: 'comment',
                    disabled: ''
                },
                commented: {
                	name: 'Commented',
                    nextStep: '',
                    disabled: 'disabled'
                }
            };

            /** @type {Date} [date object] */
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

            $('.order-container #order-info').append('<div class="shop-info">\
                <div class="pic-container">\
                    <a href="' + data.orderInfos[item].productUrl + '" target="_blank">\
                        <div class="over">\
                            <div class="link-btn"></div>\
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
                        <span class="name">Shop Owner</span>\
                        <span class="value">' + data.orderInfos[item].product.shop.name + '</span>\
                    </div>\
                    <div class="address item">\
                        <span class="name">Address</span>\
                        <span class="value">' + data.address.description + '</span>\
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
            <div class="shop-status">\
                <span class="name">status</span>\
                <span class="value">' + data.orderInfos[item].status + '</span>\
            </div>\
            <div class="shop-deliver">' + data.orderInfos[item].delivery.company + '</div>\
            <div class="shop-confirm button ' + operations[data.orderInfos[item].status].disabled + '">' + operations[data.orderInfos[item].status].name + '</div>');

            if (operations[data.orderInfos[item].status].disabled !== 'disabled') {
                $('.order-container #order-info .shop-confirm').click(function (event) {
                    /* Act on the event */
                    window.location.href = 'viewOrder?type=' + operations[data.orderInfos[item].status].nextStep + '&oid=' + oid + '&productId=' + data.orderInfos[item].productId + '&item=' + item;
                });
            }
        };

        $.ajax({
                url: 'orderByType',
                type: 'POST',
                dataType: 'json',
                data: {
                    type: 'show',
                    oid: oid
                },
            })
            .done(function (data) {
                initData(data);
            })
            .fail(function () {
                console.log("failed to get order info");
            });
    },

    initList: function () {
        "use strict";
        /**
         * [initData: init the data of orders list]
         * @return {[type]} [description]
         */
        var initData = function (data) {
            /** @type {Object} [operations of different statuses] */
            const operations = {
                unpaid: {
                    name: 'Pay',
                    nextType: 'pay',
                    disabled: ''
                },
                paid: {
                    name: 'Wait',
                    nextType: '',
                    disabled: 'disabled'
                },
                delivering: {
                    name: 'Deal',
                    nextType: 'deal',
                    disabled: ''
                },
                dealed: {
                    name: 'Comment',
                    nextType: 'comment',                
                    disabled: ''
                },
                commented: {
                	name: 'Closed',
                	nextType: '',
                	disabled: 'disabled'
                }
            };

            const detailsType = {
                unpaid: 'show',
                paid: 'show',
                delivering: 'show',
                dealed: 'show',
                commented: 'show'
            }

            /** [for: append] */
            for (let i = 0; i < data.length; i++) {
                /** date object */
                let date = new Date();

                /** loop to get shop item for this order */
                let shopItem = '';

                /** the click url */
                let clickUrl = ''

                /** order time */
                date.setTime(data[i].orderTime.time);

                for (let j = 0; j < data[i].orderInfos.length; j++) {
                    clickUrl = '';
                    if (operations[data[i].orderInfos[j].status].disabled !== 'disabled') {
                        /* Act on the event */
                        clickUrl = '?type=' + operations[data[i].orderInfos[j].status].nextType + '&oid=' + data[i].orderId + '&productId=' + data[i].orderInfos[j].productId + '&item=' + j;
                    }
                    shopItem += '<div class="shop-item">\
                        <div class="pic-container">\
                            <a href="' + data[i].orderInfos[j].productUrl + '" target="_blank">\
                                <div class="over">\
                                    <div class="link-btn"></div>\
                                </div>\
                            </a>\
                        <div class="shop" style="background-image: url(' + data[i].orderInfos[j].product.picture + ');"></div>\
                        </div>\
                        <div class="color" style="background-color: ' + data[i].orderInfos[j].color + '"></div>\
                        <div class="origin-price">\
                            <p class="origin">\
                                <s title="$' + data[i].orderInfos[j].product.price + '">$' + data[i].orderInfos[j].product.price + '</s>\
                            </p>\
                            <p class="current" title="$' + data[i].orderInfos[j].product.discountPrice + '">$' + data[i].orderInfos[j].product.discountPrice + '</p>\
                        </div>\
                        <div class="quantity">\
                            <p class="value">' + data[i].orderInfos[j].quantity + '</p>\
                            <p class="name">quantity</p>\
                        </div>\
                        <div class="price">\
                            <p class="shop-price">\
                                $' + (parseInt(data[i].orderInfos[j].quantity) * parseFloat(data[i].orderInfos[j].product.discountPrice) + parseFloat(data[i].orderInfos[j].delivery.price)) + '\
                            </p>\
                            <p class="delivery-price">delivery price: + $' + data[i].orderInfos[j].delivery.price + '</p>\
                        </div>\
                        <div class="info">\
                            <div class="delivery-status">\
                                <p class="value">' + data[i].orderInfos[j].status + '</p>\
                                <p class="name">delivery status</p>\
                                <p><a class="value" href="viewOrder?type=' + detailsType[data[i].orderInfos[j].status] + '&oid=' + data[i].orderId + '&item=' + j + '">details</a></p>\
                                <p class="name">more details</p>\
                                <p><a class="value" href="#">track the delivery</a></p>\
                                <p class="name">track where the shop is</p>\
                            </div>\
                        </div>\
                        <div class="handle-btn button ' + operations[data[i].orderInfos[j].status].disabled + '" onclick="window.location.href=\'' + clickUrl + '\'">' + operations[data[i].orderInfos[j].status].name + '</div>\
                    </div>';  
                }

                $('.order-container #order-list').append('<div class="order-item">\
                    <div class="brief-info">\
                        <div class="order-id">\
                            <span class="name">order id:</span>\
                            <span class="value">' + data[i].orderId + '</span>\
                        </div>\
                        <div class="order-ctime">\
                            <span class="value"> ' + date.format('yyyy-MM-dd hh:mm:ss') + ' </span>\
                        </div>\
                        <div class="delete-btn button"></div>\
                    </div>' + shopItem + '</div>');
            }
        };

        /** get data by uid and page */
        $.ajax({
                url: 'orderByType',
                type: 'POST',
                dataType: 'json',
                data: {
                    type: 'list'
                },
            })
            .done(function (data) {
                /** init the data */
                initData(data);

                /** [click function of delete order] */
                $('.order-container #order-list .order-item .delete-btn').click(function (event) {
                    const _this = $(this);

                    $.getJSON('deleteOrder', {
                        oid: $(this).prev().prev().children('.value').html()
                    }, function (data, textStatus) {
                        console.log(data.success);
                        /*optional stuff to do after success */
                        if (!data.success) {
                            alert('failed to delete a order which state is not `unpaid`');
                        } else {
                            /** remove dom node */
                            _this.parent().parent().remove();
                        }
                    });
                })
            })
            .fail(function () {
                console.log("failed to get orders list");
            });
    },

    /**
     * [initSearchPage: init the search page]
     * @return {[type]} [description]
     */
    initSearchPage: function () {
        $('#searchMethod').change(function(event) {
            /* Act on the event */
            if ($(this).val() === 'shopName') {
                $(this).next().hide();
            } else {
                $(this).next().show();
            }
        });
    },

    /**
     * [initPay: init the page page of order]
     * @return {[type]} [description]
     */
    initPay: function (oid) {
        "use strict";
        /** check whether pay or not */
        $.getJSON('orderByType', {
            type: 'show',
            oid: oid
        }, function (data, textStatus) {
            /*optional stuff to do after success */
            const productId = $('#productId').val();
            if (productId === 'null') {
                let i;
                for (i = 0; i < data.orderInfos.length; i++) {
                    if (data.orderInfos[i].status !== 'unpaid') {
                        break;
                    }
                }

                if (i !== data.orderInfos.length) {
                    $('.order-container #pay-info').html('You cannot pay the order');
                    $('.order-container #pay-btn').css({
                        'border': '2px solid #e0e0e0',
                        'background-color': '#f0f0f0',
                        'color': '#e0e0e0'
                    });
                    return;
                }
            } else {
                for (let i = 0; i < data.orderInfos.length; i++) {
                    if (data.orderInfos[i].productId == productId && data.orderInfos[i].status !== 'unpaid') {
                        $('.order-container #pay-info').html('You cannot pay the order');
                        $('.order-container #pay-btn').css({
                            'border': '2px solid #e0e0e0',
                            'background-color': '#f0f0f0',
                            'color': '#e0e0e0'
                        });
                        return;
                    }
                }
            }

            $('.order-container #pay-info').html('Pay the product');
            $('.order-container #pay-btn').click(function () {
                $.getJSON('payOrder', {
                    oid: oid,
                    productId: $('#productId').val()
                }, function (data, textStatus) {
                    /*optional stuff to do after success */
                    if (data.result) {
                        $('.order-container #pay-btn').css({
                            'border': '2px solid #e0e0e0',
                            'background-color': '#f0f0f0',
                            'color': '#e0e0e0'
                        });

                        $('.order-container #pay-btn').removeClass('button');

                        $('.order-container #pay-btn').unbind('click');
                    } else {
                        alert('Ooops, failed to pay');
                    }
                });
            });
        });
    },

    /**
     * [initDeal: init the deal page]
     * @param  {[type]} oid       [the order id]
     * @param  {[type]} productId [the product id]
     * @return {[type]}           [description]
     */
    initDeal: function (oid, productId) {
        "use strict";
        /** check whether deal or not */
        $.getJSON('orderByType', {
            type: 'show',
            oid: oid
        }, function (data, textStatus) {
            /*optional stuff to do after success */
            const productId = $('#productId').val();
            for (let i = 0; i < data.orderInfos.length; i++) {
                if (data.orderInfos[i].productId == productId && data.orderInfos[i].status === 'deal') {
                    $('.order-container #deal-info').html('You have already dealed');
                    $('.order-container #deal-btn').css({
                        'border': '2px solid #e0e0e0',
                        'background-color': '#f0f0f0',
                        'color': '#e0e0e0'
                    });
                    return;
                } else if (data.orderInfos[i].productId == productId && data.orderInfos[i].status === 'paid') {
                    $('.order-container #deal-info').html('You cannot deal before the product have been sent');
                    $('.order-container #deal-btn').css({
                        'border': '2px solid #e0e0e0',
                        'background-color': '#f0f0f0',
                        'color': '#e0e0e0'
                    });
                    return;
                } else if (data.orderInfos[i].productId == productId && data.orderInfos[i].status !== 'delivering') {
                    $('.order-container #deal-info').html('You cannot deal the product');
                    $('.order-container #deal-btn').css({
                        'border': '2px solid #e0e0e0',
                        'background-color': '#f0f0f0',
                        'color': '#e0e0e0'
                    });
                    return;
                }
            }

            $('.order-container #deal-info').html('Are you sure to deal?');
            $('.order-container #deal-btn').click(function () {
                $.getJSON('changeOrderInfo', {
                    oid: oid,
                    pid: $('#productId').val(),
                    newStatus: 'dealed'
                }, function (data, textStatus) {
                    /*optional stuff to do after success */
                    if (data.success) {
                        $('.order-container #deal-btn').css({
                            'border': '2px solid #e0e0e0',
                            'background-color': '#f0f0f0',
                            'color': '#e0e0e0'
                        });

                        $('.order-container #deal-btn').removeClass('button');

                        $('.order-container #deal-btn').unbind('click');
                    } else {
                        alert('Ooops, failed to deal');
                    }
                });
            });
        });
    },

    /**
     * [initProductInfo: init the product info]
     * @return {[type]} [description]
     */
    initProductInfo: function () {
        const $scores = $('.product-container .product-area .comments .comment-items .value > span');

        let scores = 0;
        let i = 0;
        let avg;
        $scores.each(function () {
            i++;
            scores += parseFloat($(this).html());
        });
        
        avg = (i == 0) ? 0.0 : scores / i;
        $('.product-container .product-area .main > span .averageValue').html((avg).toFixed(1));

        $('.product-container .product-info .info-items .value input[type="number"]').change(function () {
            /* Act on the event */
            const _this = $(this);
            /** check legality when keydown */
            const regex = new RegExp("^[0-9]*[1-9][0-9]*$");
            if (regex.test($(this).val())) {
                if (parseInt($(this).val()) > parseInt($(this).attr('max_quantity'))) {
                    $(this).focus();
                    $(this).val($(this).attr('max_quantity'));
                    alert('the product is limited for sale');
                } else {
                    /** do nothing */
                }
            } else {
                $(this).focus();
                $(this).val(Math.abs(parseInt($(this).val())));
                alert('you can only enter integer number between 1 and 99');
            }
        });

        $('.jqzoom').jqzoom({
            zoomType: 'standard',
            lens: true,
            preloadImages: false,
            alwaysOn: true
        });
        
        $('.product-container .img-area').hover(function (event) {
            /* Stuff to do when the mouse enters the element */
            $('.zoomPad .zoomPup').show().css({
                opacity: 0.6
            });
            
            $('.zoomPad .zoomWindow').show().css({
                opacity: 1
            });
        }, function () {
            /* Stuff to do when the mouse leaves the element */
            $('.zoomPad .zoomPup, .zoomPad .zoomWindow').hide();
        });
    }
};
