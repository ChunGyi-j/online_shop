$(function() {

	$('.button').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#editDialog').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('.button2').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#editDialog2').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('.button3').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#editDialog3').modal()
	})

	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})
	$('#addcity').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#editDialog4').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('#photo').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#profilephoto').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('#name').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#changename').modal()
	})

	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})
	$('#password').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#changepassword').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('#address').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#changeaddress').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('#password').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#changepassword').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})

	$('#address').click(function(event) {
		let code = $(event.currentTarget).prev().html()
		let action = $('#editForm').attr("action")

		$('#editForm').attr('action', `${action}`)
		$('#editName').val(code)

		$('#changeaddress').modal()
	})
	$('#saveBtn').click(function() {
		$('#editForm').submit()
	})


})