// JavaScript Document
$(document).ready(function(e) {
	$("#getCu").bind("click", getCusJson);
	$("#twopage").bind("click", {
		i : '2'
	}, numpage);
	$("#onepage").bind("click", {
		i : '1'
	}, numpage);
	$("#threepage").bind("click", {
		i : '3'
	}, numpage);
	$("#btn-g").hide();

});

function getCusJson() {
	$("#btn-g").show();
	$('.kk').bind("click", putidm);

	$.getJSON('/StrutsExam8832/getCus',
			function(data) {
				var html = '<table style="height:100%;width:100%;">';

				$
						.each(
								data,
								function(entryIndex, entry) {
									if (entryIndex < 10) {

										html += '<tr><td><a onclick="putidm(this)" role="button" class="btn"  >编辑</a>'
												+ '<td><a onclick="del(this)">'
												+ '删除</a></td>'
												+ '<td>'
												+ entry.first_name
												+ '</td>'
												+ '<td>'
												+ entry.last_name
												+ '</td>'
												+ '<td>'
												+ entry.address
												+ '</td>'
												+ '<td>'
												+ entry.email
												+ '</td>'
												+ '<td>'
												+ entry.customer_id
												+ '</td>'
												+ '<td>'
												+ entry.last_update
												+ '</td>';

										html += '</tr>';
									}
								});
				html += '</table>';

				$("#table").html(html);
				
			});

}
function numpage(event) {

	$
			.getJSON(
					'../StrutsExam8832/getCus',
					function(Jsondata) {
						var html = '<table style="height:100%;width:100%;">';
						var endpage = event.data.i * 10;
						var startpage = (event.data.i * 10) - 12;

						$
								.each(
										Jsondata,
										function(entryIndex, entry) {
											if (entryIndex < endpage
													&& entryIndex > startpage) {
												html += '<tr><td><a onclick="putidm(this)" role="button" class="btn"  >编辑</a>'
														+ '<td><a onclick="del(this)">'
														+ '删除</a></td>'
														+ '<td>'
														+ entry.first_name
														+ '</td>'
														+ '<td>'
														+ entry.last_name
														+ '</td>'
														+ '<td>'
														+ entry.address
														+ '</td>'
														+ '<td>'
														+ entry.email
														+ '</td>'
														+ '<td>'
														+ entry.customer_id
														+ '</td>'
														+ '<td>'
														+ entry.last_update
														+ '</td>';

												html += '</tr>';
											}
										})
						html += '</table>';

						$("#table").html(html);
						return false;
					});

}

function putidm(thisObj) {

	var $td = $(thisObj).parents('tr').children('td');

	$("#gid ").attr("value", $td.eq(6).text());
	$("#fn").attr("value", $td.eq(2).text());
	$("#ln").attr("value", $td.eq(3).text());
	$("#em").attr("value", $td.eq(5).text());
	$("#myModal").modal();

};

function del(thisObj) {
	var $td = $(thisObj).parents('tr').children('td');
	alert("确定删除？" + $td.eq(6).text())

	$.get("../StrutsExam8832/del?id=" + $td.eq(6).text());
	var $tr = $(thisObj).parents('tr');
	$tr.hide();
};

