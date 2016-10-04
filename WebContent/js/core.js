/**
 * Created by com on 2016-10-03.
 */
$(document).ajaxError(function( event, jqxhr, settings, thrownError ) {
    alert(jqxhr.responseText);
});