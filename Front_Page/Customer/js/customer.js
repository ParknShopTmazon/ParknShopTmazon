"use strict";

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
                'certain-delete-main': 'main'
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
             * [getDialog: get the dialog of the specified uid]
             * @param  {[type]} uid [the uid]
             * @return {[type]}     [description]
             */
            getDialog = function(uid) {
                console.log('uid: ' + uid);
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
            getDialog($(this).attr('uid'));
        });

        /** [click function of add friend button] */
        $('.dialog #main .bottom-buttons .add-friend-btn').click(function() {
            showPart('add-friend-main');
        });

        /** [click function of search button on the add friend page] */
        $('.dialog #add-friend-main .search-btn').click(function() {
            showPart('people-list-main');
        });

        /** [click function of certaining to add friends] */
        $('.dialog #people-list-main .bottom-buttons .certain-btn').click(function() {
            showPart('certain-add-main');
        });

        /** [click function or certaining to delete friends] */
        $('.dialog #main .bottom-buttons .del-friend-btn').click(function() {
            showPart('certain-delete-main');
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
            /** update quality */
            $('#shop-cost .quality .value').html(list.length);

            origin_cost = right_cost = 0;

            /** update cost */
            for (var i = 0; i < list.length; i++) {
                origin_cost += parseFloat(origin_list[i].textContent.substring(1, origin_list[i].textContent.length));
                right_cost += parseFloat(right_list[i].textContent.substring(1, right_list[i].textContent.length));
            }
            $('#shop-cost .origin .value').html('<s>$' + origin_cost.toFixed(1) + '</s>');
            $('#shop-cost .cost .value').html('$' + right_cost.toFixed(1));
        };

        /** get data by uid */
        $.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data: {
                    uid: ''
                },
            })
            .done(function() {})
            .fail(function() {})
            .always(function() {
                console.log("get cart data complete");
            });

        /** test data */
        var testData = "{\n\t\"cid\": \"1\",\n\t\"cart\": [\n\t\t{\n\t\t\t\"sid\" : \"1\",\n\t\t\t\"name\": \"shop1\",\n\t\t\t\"size\": \"S\",\n\t\t\t\"origin_price\": \"38.9\",\n\t\t\t\"price\": \"28.9\",\n\t\t\t\"quality\": 2,\n\t\t\t\"color\": \"#000000\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop1.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t},\n\t\t{\n\t\t\t\"sid\" : \"2\",\n\t\t\t\"name\": \"shop2\",\n\t\t\t\"size\": \"XL\",\n\t\t\t\"origin_price\": \"29.9\",\n\t\t\t\"price\": \"25.9\",\n\t\t\t\"quality\": 1,\n\t\t\t\"color\": \"#232122\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop2.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t},\n\t\t{\n\t\t\t\"sid\" : \"3\",\n\t\t\t\"name\": \"shop3\",\n\t\t\t\"size\": \"XXL\",\n\t\t\t\"origin_price\": \"59.9\",\n\t\t\t\"price\": \"35.9\",\n\t\t\t\"quality\": 1,\n\t\t\t\"color\": \"#d1b699\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop3.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t},\n\t\t{\n\t\t\t\"sid\" : \"4\",\n\t\t\t\"name\": \"shop4\",\n\t\t\t\"size\": \"L\",\n\t\t\t\"origin_price\": \"30.9\",\n\t\t\t\"price\": \"25.9\",\n\t\t\t\"quality\": 1,\n\t\t\t\"color\": \"#3f205c\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop4.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t}\n\t]\n}\n";

        /** parse */
        var cart = JSON.parse(testData).cart;
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
					<div class="quality sub-main">\
						<span>quality</span>\
						<span class="value">\
							<input type="number" min="1" value="' + cart[i].quality + '">\
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

        /** update cost info at the beginning */
        updateCost();

        /** delete shop item */
        $('.cart-container #shop-lists .shop-item .shop-info .delete .value').click(function() {
            $(this).parent().parent().parent().remove();
            updateCost();
        });

        /** [click function of the pay button] */
        $('.cart-container #shop-cost .pay .value').click(function(){
        	window.location.href = "./order.jsp?type=certain";
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
                    // console.log("success");
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

            cost = 0;

            /** update cost */
            for (var i = 0; i < list.length; i++) {
            	var priceItem = list[i].textContent;
            	priceItem = parseFloat(priceItem.substring(1, priceItem.length));

            	cost += priceItem;
            }

            /** set the cost info */
            $('.order-container #final-order .real .value').html('$' + cost.toFixed(1));
        };
        /** get data by uid */
        $.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data: {
                    uid: ''
                },
            })
            .done(function() {})
            .fail(function() {})
            .always(function() {
                console.log("get cart data complete");
            });

        /** test data */
        var testData = "{\n\t\"cid\": \"1\",\n\t\"cart\": [\n\t\t{\n\t\t\t\"sid\" : \"1\",\n\t\t\t\"name\": \"shop1\",\n\t\t\t\"size\": \"S\",\n\t\t\t\"origin_price\": \"38.9\",\n\t\t\t\"price\": \"28.9\",\n\t\t\t\"quality\": 2,\n\t\t\t\"color\": \"#000000\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop1.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t},\n\t\t{\n\t\t\t\"sid\" : \"2\",\n\t\t\t\"name\": \"shop2\",\n\t\t\t\"size\": \"XL\",\n\t\t\t\"origin_price\": \"29.9\",\n\t\t\t\"price\": \"25.9\",\n\t\t\t\"quality\": 1,\n\t\t\t\"color\": \"#232122\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop2.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t},\n\t\t{\n\t\t\t\"sid\" : \"3\",\n\t\t\t\"name\": \"shop3\",\n\t\t\t\"size\": \"XXL\",\n\t\t\t\"origin_price\": \"59.9\",\n\t\t\t\"price\": \"35.9\",\n\t\t\t\"quality\": 1,\n\t\t\t\"color\": \"#d1b699\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop3.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t},\n\t\t{\n\t\t\t\"sid\" : \"4\",\n\t\t\t\"name\": \"shop4\",\n\t\t\t\"size\": \"L\",\n\t\t\t\"origin_price\": \"30.9\",\n\t\t\t\"price\": \"25.9\",\n\t\t\t\"quality\": 1,\n\t\t\t\"color\": \"#3f205c\",\n\t\t\t\"shop_url\": \"#\",\n\t\t\t\"shop_pic\": \".\/images\/shops\/shop4.jpg\",\n\t\t\t\"delivery_options\": [\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"STO inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.0\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t},\n\t\t\t\t{\n\t\t\t\t\t\"company_name\": \"EMS inc.\",\n\t\t\t\t\t\"price_option\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"10.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $10(normal)\"\n\t\t\t\t\t\t},\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"value\": \"12.8\",\n\t\t\t\t\t\t\t\"description\": \"delivery price: $12.8(fast)\"\n\t\t\t\t\t\t}\n\t\t\t\t\t]\n\t\t\t\t}\n\t\t\t]\n\t\t}\n\t]\n}\n";

        /** parse */
        var cart = JSON.parse(testData).cart,
            origin_cost = 0,
            right_cost = 0,
            delivery_infos = {};
        for (var i in cart) {
            /** calculate the cost */
            origin_cost += parseFloat(cart[i].origin_price);
            right_cost += parseFloat(cart[i].price);

            /** generate delivery company options */
            var company_options = '';
            for (var j in cart[i].delivery_options) {
            	company_options += '<option value="' + j + '">' + cart[i].delivery_options[j].company_name + '</option>';
            }

            /** generate options of the first company */
            var price_options = '';
            for (var j in cart[i].delivery_options[0].price_option) {
            	price_options += '<option value="' + cart[i].delivery_options[0].price_option[j].value + '">' + cart[i].delivery_options[0].price_option[j].description + '</option>';
            }

            /** append list item */
            $('.order-container #order-details').append('<div class="order-item">\
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
	                <p class="shop-price">$' + (parseFloat(cart[i].price) + parseFloat(cart[i].delivery_options[0].price_option[0].value)).toFixed(1) + '</p>\
	                <p class="delivery-price">+ $' + cart[i].delivery_options[0].price_option[0].value + '</p>\
	            </div>\
        	</div>');
        }

        /** update cost info */
        updateCost();

        $('.order-container #order-details .order-delivery').change(function() {
        	console.log(cart);
        });

        /** [delivery price change] */
        $('.order-container #order-details .order-delivery-price').change(function() {
        	/** @type {[type]} [the selected delivery price] */
        	var selectPrice = parseFloat($(this).children('select').val());

        	/** @type {[type]} [cost without delivery price] */
        	var origin_cost = $(this).prev().prev().children('span').html();
        	origin_cost = parseFloat(origin_cost.substring(1, origin_cost.length));

        	/** update cost of the item */
        	$(this).next().children('.delivery-price').html('+ $' + selectPrice.toFixed(1));
        	$(this).next().children('.shop-price').html('$' + (origin_cost + selectPrice).toFixed(1));

        	/** update cost info */
        	updateCost();
        });

    },

    initShow: function() {
        "use strict";
    },

    initList: function() {
        "use strict";
    }
};
