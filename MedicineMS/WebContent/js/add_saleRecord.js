 /*
    Date:2017-06-18
    Author:Johnny Zen
    Description:添加销售记录脚本
 */
 //是否包含中文
    function isContainsChiense(str) {
        // alert(str);	//test
        // var str = '我ert爱中华5787rt58e757';//test
        if (escape(str).indexOf("%u") < 0) {
            /* alert("没有包含中文"); */
            return false;
        } else {
            /* alert("包含中文"); */
            return true;
        }
    }

    function commitMedicineSaleRecord() {

        //设置提交时的文本字符集编码
        document.charset = 'utf-8';
        // alert(document.getElementById('createMedicineSaleRecord').action); //test

        var createMedicineSaleRecord = document.createMedicineSaleRecord_form;
        // alert('点击');	
        var inputs = createMedicineSaleRecord.getElementsByTagName('input'); //获取input数组
        //检查国药准字号
        if (inputs[0].value.length < 8 || inputs[0].value.length > 10) { //国药准字号长度[8,10]
            // alert("温馨提示：请填写符合国家标准规范的国药准字号.");
            inputs[0].value = "";
            inputs[0].placeholder = '温馨提示：请填写符合国家标准规范的国药准字号!';
            // inputs[0].style.color = 'red';
            // $(inputs[0]).$(":-webkit-placeholder").css("color","green");
            inputs[0].focus();
            return false;
        }
        //不能包含非ASCII字符值
        //测试数据：中文中文12345
        if (isContainsChiense(inputs[0].value) == true) {
            // alert("不能包含中文");
            inputs[0].value = "";
            inputs[0].placeholder = '不能包含中文!';
            inputs[0].style.color = 'red';
            inputs[0].focus();
            return false;
        }

        var isOk = true;//假定isOK：可以通过
        
        //判断支付金额是否大于应付金额
        var salePrice = parseFloat(inputs[3].value);//药品销售价格
        var medicineAmount = parseInt(inputs[4].value);//药品销售数目
        var payAmountMoney = parseInt(inputs[5].value);//顾客支付金额
        var FactPayMoney = parseFloat(salePrice*medicineAmount); //实际应付金额
        // alert("药品销售价格："+salePrice+"\n药品销售价格："+medicineAmount+"\n顾客支付金额："+payAmountMoney+"\n实际应付金额："+FactPayMoney);
        if(FactPayMoney>payAmountMoney){
            inputs[5].value = "";
            inputs[5].placeholder = '当前实际应付金额应该不小于'+FactPayMoney+"元";
            inputs[5].style.color = 'red';
            inputs[5].focus();
            isOk = false;
        }

        //判断表单元素是否全部填充完毕
        for(var i=0;i<inputs.length-1;i++){ //-1：减去提交元素
        	if(inputs[i].value.length<1){
        		isOk = false;
        		break;
        	}
        }
        //如果上述条件均通过，才执行以下函数
        if(isOk){
        	refresh_overlay();
        }
        else{
        	return false;
        }
        	
    }
    
    // // onclick="refresh_overlay()"
    // /*切换模态框*/
    // window.onload = function() {
    //     closeModal();
    //     // refresh_overlay();    
    // }

    // function closeModal() { //ok
    //     var modal_div = document.getElementById('modal_div');
    //     $('#close_btn').click(function() {
    //         $('#modal_div').hide();
    //     });
    // }

    // function closeForm() {
    //     $('#form').click(function() {
    //         $('#modal_div').hide();
    //     });
    // }

    // function showModal() {
    //     // var modal_div = document.getElementById('modal_div');
    //     // $('#close_btn')
    //     $('#modal_div').show();
    // }

    // function refresh_overlay() {
    //     $('#form').hide();
    //     // var div = document.getElementById('fresh_overlay_div');
    //     // alert('test');
    //     $('#fresh_overlay_div').show();
    //     // showModal();
    // }