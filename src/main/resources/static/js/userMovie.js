$(document).ready(function(){

    getMovieList();

    function getMovieList() {
        $.ajax({
            type: 'GET',
            url: '/movie/all',
            async: true,
            success: function (res) {
                renderMovieList(res.content);
            },
            error: function (error) {
                alert(error);
            }
        });
    }

    function renderMovieList(list) {
        $('.movie-on-list').empty();
        var movieDomStr = '';
        list.forEach(function (movie) {
            movie.description = movie.description || '';
            movieDomStr +=
                "<li class='movie-item card' id='movie-"+ movie.id +"'>" +
                "<img class='movie-img' src='" + (movie.posterUrl || "../images/bg.jpg") + "'/>" +
                "<div class='movie-info'>" +
                "<p class='movie-title primary-text'>" +
                "<span>" + movie.name + "</span>" +
                "<span class='label "+(movie.showState ? 'primary-bg' : 'error-bg')+"'>" + (movie.showState ? '上映中' : '未上映') + "</span>" +
                "<button type='button' class='btn btn-default btn-sm to-buy-btn'>前往购票</button>" +
                "</p>" +
                "<p class='dark-text'>" + (movie.description.length < 160 ? movie.description : (movie.description.substr(0,160) + '...')) + "</p>" +
                "<p>" +
                "<span>导演：" + movie.director + "</span><span style='margin-left: 30px;'>主演：" + movie.starring + "</span></p>" +
                "<p class='movie-type-want'><span>类型：" + movie.type + "</span><span class='movie-want'><i class='icon-heart error-text'></i>" + (movie.wantWatch || 0) + "人想看</span></p>" +
                "</div>"+
                "</li>";
        });
        $('.movie-on-list').append(movieDomStr);
    }

    $(document).on('click','.to-buy-btn',function (e) {
        var id = $(e.target).parents('.movie-item').attr('id').split('-')[1];
        console.log(id);
    });
});