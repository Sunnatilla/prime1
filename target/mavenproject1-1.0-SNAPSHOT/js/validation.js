
var boolCR_SUM;
var boolCR_OWN_SUM;
var boolCR_MONTHES;
var boolCR_FEE_RATE;

$(document).ready(function(){
    var pattern = /^[1-9]\d*$/; 
    
    var CR_SUM = $('#CR_SUM');
    
    CR_SUM.blur(function(){
        if(CR_SUM.val() != ''){
            if(CR_SUM.val().search(pattern) == 0){
                $('#valid_CR_SUM').html("<span id='valid_CR_SUM'><img src='img/correct.png' /></span>");
                boolCR_SUM = true;
                buttonOnAndOff();
            }else{
                $('#valid_CR_SUM').html("<span id='valid_CR_SUM'><img src='img/error.png' /></span>");
                boolCR_SUM = false;
                buttonOnAndOff();
            }
        }else{
                $('#valid_CR_SUM').html("<span id='valid_CR_SUM'><img src='img/empty.png' /></span><span id='text_first_name'></span");
                $('#text_first_name').text('не заполнено');
                boolCR_SUM = false;
                buttonOnAndOff();
        }
    });
    
    
    
    
    
    
    
    var CR_OWN_SUM = $('#CR_OWN_SUM');
    
    CR_OWN_SUM.blur(function(){
        if(CR_OWN_SUM.val() != ''){
            if(CR_OWN_SUM.val().search(pattern) == 0){
                $('#valid_CR_OWN_SUM').html("<span id='valid_CR_OWN_SUM'><img src='img/correct.png' /></span>");
                boolCR_OWN_SUM = true;
                buttonOnAndOff();
            }else{
                $('#valid_CR_OWN_SUM').html("<span id='valid_CR_OWN_SUM'><img src='img/error.png' /></span>");
                boolCR_OWN_SUM = false;
                buttonOnAndOff();
            }
        }else{
                $('#valid_CR_OWN_SUM').html("<span id='valid_CR_OWN_SUM'><img src='img/empty.png' /></span><span id='text_first_name'></span");
                $('#text_first_name').text('не заполнено');
                boolCR_OWN_SUM = false;
                buttonOnAndOff();
        }
    });
    
    
    
    
    
    var CR_MONTHES = $('#CR_MONTHES');
    
    CR_MONTHES.blur(function(){
        if(CR_MONTHES.val() != ''){
            if(CR_MONTHES.val().search(pattern) == 0){
                $('#valid_CR_MONTHES').html("<span id='valid_CR_MONTHES'><img src='img/correct.png' /></span>");
                boolCR_MONTHES = true;
                buttonOnAndOff();
            }else{
                $('#valid_CR_MONTHES').html("<span id='valid_CR_MONTHES'><img src='img/error.png' /></span>");
                boolCR_MONTHES = false;
                buttonOnAndOff();
            }
        }else{
                $('#valid_CR_MONTHES').html("<span id='valid_CR_MONTHES'><img src='img/empty.png' /></span><span id='text_first_name'></span");
                $('#text_first_name').text('не заполнено');
                boolCR_MONTHES = false;
                buttonOnAndOff();
        }
    });
    
    
    
    
    
    
    
    
    var CR_FEE_RATE = $('#CR_FEE_RATE');
    
    CR_FEE_RATE.blur(function(){
        if(CR_FEE_RATE.val() != ''){
            if(CR_FEE_RATE.val().search(pattern) == 0){
                $('#valid_CR_FEE_RATE').html("<span id='valid_CR_FEE_RATE'><img src='img/correct.png' /></span>");
                boolCR_FEE_RATE = true;
                buttonOnAndOff();
            }else{
                $('#valid_CR_FEE_RATE').html("<span id='valid_CR_FEE_RATE'><img src='img/error.png' /></span>");
                boolCR_FEE_RATE = false;
                buttonOnAndOff();
            }
        }else{
                $('#valid_CR_FEE_RATE').html("<span id='valid_CR_FEE_RATE'><img src='img/empty.png' /></span><span id='text_first_name'></span");
                $('#text_first_name').text('не заполнено');
                boolCR_FEE_RATE = false;
                buttonOnAndOff();
        }
    });
    
       
    
    });
    
    
    function buttonOnAndOff(){
            if(boolCR_FEE_RATE && boolCR_MONTHES && boolCR_OWN_SUM && boolCR_SUM){
		$('#submit').removeAttr("disabled");
            }
            else{
                $("#submit").attr("disabled","disabled");
			
            }
    }