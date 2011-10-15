$(document).ready(function() {
    $(function() {
	$(".term").datepicker({
	    dateFormat: 'dd/mm/yy',
	    dayNamesMin: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"],
	    monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"]
	});
    });
});