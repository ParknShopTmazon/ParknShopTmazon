"use strict";
/**
 * [comet: the class of comet]
 * @type {Object}
 */
const Comet = {
    /**
     * [release: release memory]
     * @return {[type]} [description]
     */
    release: function() {
        clearTimeout(this._timeout);
    },

    /**
     * [subscribe: a method to storing post data and callback function]
     * @param  {Object}   postData [post data]
     * @param  {Function} callback [callback function]
     * @return {[type]}            [description]
     */
    subscribe: function(postData, callback) {
        "use strict";
        this._subscribed = postData;
        this._subscribed['sleepTime'] = this._sleepTime;
        this._subscribed['count'] = this._count;
        this._callback = callback;
        return this;
    },

    /**
     * [init: the constructor of the class]
     * @param  {[type]} baseurl   [the url you want to post to]
     * @param  {[type]} sleepTime [optional]
     * @param  {[type]} count     [optional]
     * @return {[type]}           [description]
     */
    init: function(baseurl, sleepTime, count) {
        "use strict";
        sleepTime = sleepTime || 2000;
        count = count || 1;
        if (baseurl != undefined) {
            this._baseurl = baseurl;
        }


        /**
         * [sleepTime: the time during each refresh]
         * @type {Number}
         */
        this._sleepTime = sleepTime;

        /**
         * [_subscribed: an object for storing your post data]
         * @type {Object}
         */
        this._subscribed = {};

        /**
         * [_timeout: an object for storing a timeout instance]
         * @type {[type]}
         */
        this._timeout = null;

        /**
         * [_baseurl: the url which you want to post to]
         * @type {String}
         */
        this._baseurl = baseurl;

        /**
         * [callback: an object for storing the callback function]
         * @type {Function}
         */
        this._callback = null;

        /**
         * [_sleepCount: the count during each handling, like searching databases]
         * @type {Number}
         */
        this._sleepCount = 1;

        /**
         * [_count: point out how many times you want to handle for each ajax]
         * @type {Number}
         */
        this._count = count;

        /**
         * [_refresh: a method to refresh to run another ajax]
         * @return {[type]} [description]
         */
        this._refresh = function() {
            "use strict";
            const _this = this;
            this._timeout = setTimeout(function() {
                console.log('refresh to run');
                _this.run(_this._len);
            }, this._sleepTime);
        };
    },
    
    /**
     * [run: run the ajax]
     * @param  {[type]}   len [the compared len]
     * @return {[type]}       [description]
     */
    run: function(len) {
        "use strict";
        const _this = this;
        
        _this._len = len;
        
        
        $.getJSON(this._baseurl, this._subscribed, function(data) {
            /** you can modify as you like in this part to 
             *  judge which conditions are the trigger point
             */
            if (data.messages.length === _this._len) {
                _this._refresh();
            } else {
            	_this._len = data.messages.length;
            	_this._callback();
            	_this._refresh();
            }
        });
    },

    /**
     * [publish: for test]
     * @return {[type]} [description]
     */
    publish: function() {
        this._callback();
    }
};
