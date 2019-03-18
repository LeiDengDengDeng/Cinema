function checkLogin() {

}

function postRequest() {
    $.ajax({
        type: 'POST',
        url: '/movie/add',
        data: JSON.stringify(getMovieForm()),
        async: true,
        contentType: 'application/json',
        processData: false,
        success: function (res) {
            getMovieList();
            $("#movieModal").modal('hide');
        },
        error: function (error) {
            alert(error);
        }
    });
}
