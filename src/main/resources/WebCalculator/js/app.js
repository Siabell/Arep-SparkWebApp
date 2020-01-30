app = (function () {
    var dataList;

    return {
        setData: function () {
            dataList = document.getElementById("data").value;
            
        },

        showResultCalculation: function (result) {
            $("#mean").empty();
            $("#standDev").empty();
            
            var datos = JSON.parse(result);
            var mean = "Mean : " +datos.mean;
            var standDev = "Standard Deviation : "+datos.standDev;

            $("#mean").append(mean);
            $("#standDev").append(standDev);
            
            

            
        },

        calculate: function () {           
            app.setData();
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            api.getResult(dataList, app.showResultCalculation);
            
        }
    };
})();

api = (function () {

    
    return {      
        getResult: function (dataList, callback) {
            //alert( "Load was performed." );
            $.get( '/calculator/'+dataList, function( data ) {
        	    callback(data);
        		
        		});
        	
        }
    };

})();