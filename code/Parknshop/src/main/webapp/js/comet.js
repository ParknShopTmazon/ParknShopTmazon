"use strict";
/**
 * [comet: the class of comet]
 * @type {Object}
 */
class comet {
    /**
     * [release: release memory]
     * @return {[type]} [description]
     */
    release() {
        clearTimeout(this._timeout);
    }

    /**
     * [subscribe: a method to storing post data and callback function]
     * @param  {Object}   postData [post data]
     * @param  {Function} callback [callback function]
     * @return {[type]}            [description]
     */
    subscribe(postData, callback) {
        "use strict";
        this._subscribed = postData;
        this._subscribed['sleepTime'] = this._sleepTime;
        this._subscribed['count'] = this._count;
        this._callback = callback;
        return this;
    }

    /**
     * [constructor: the constructor of the class]
     * @param  {[type]} baseurl   [the url you want to post to]
     * @param  {[type]} sleepTime [optional]
     * @param  {[type]} count     [optional]
     * @return {[type]}           [description]
     */
    constructor(baseurl, sleepTime, count) {
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
        this._baseurl = '';

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
            this._timeout = setTimeout(function() {
                console.log('refresh to run');
                this.run()
            }, this._sleepTime);
        };
    }

    /**
     * [run: run the ajax]
     * @param  {[type]}   len [the compared len]
     * @return {[type]}       [description]
     */
    run(len) {
        "use strict";
        $.getJSON(comet._baseurl, comet._subscribed, function(data) {
            /** you can modify as you like in this part to 
             *  judge which conditions are the trigger point
             */
            if (data.messages.length === len) {
                this._refresh();
            } else {
                this._callback();
            }
        });
    }

    /**
     * [publish: for test]
     * @return {[type]} [description]
     */
    publish() {
        this._callback();
    }
};
