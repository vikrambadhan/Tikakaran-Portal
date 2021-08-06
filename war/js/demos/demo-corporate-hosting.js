/*
Name: 			Corporate Hosting
Written by: 	Okler Themes - (http://www.okler.net)
Theme Version:	4.6.0
*/

(function( $ ) {

	'use strict';

	// Domain Search Form
	$('#domainSearchForm').validate({
		errorPlacement: function(error, element) {
			error.appendTo(element.parent().parent());
		}		
	});

	// Domain Dropdown
	$('#tldBtn').html($('input[name=tld]').val() + ' <span class="caret"></span>')

	$('#tld a').on('click', function(e) {
		e.preventDefault();
		$('input[name=tld]').val($(this).text());
		$('#tldBtn').html($(this).text() + ' <span class="caret"></span>')
	});


}).apply( this, [ jQuery ]);