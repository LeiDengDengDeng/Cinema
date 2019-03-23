$(document).ready(function(){

    var movieId = parseInt(window.location.href.split('?')[1].split('&')[0].split('=')[1]);
    var userId = sessionStorage.getItem('id');
    var isLike = false;

    getMovie();

    function getMovie() {
        // repaintMovieDetail({
        //     country: null,
        //     description: "在人与妖怪之间过着忙碌日子的夏目，偶然与以前的同学结城重逢，由此回忆起了被妖怪缠身的苦涩记忆。此时，夏目认识了在归还名字的妖怪记忆中出现的女性·津村容莉枝。和玲子相识的她，现在和独子椋雄一同过着平稳的生活。夏目通过与他们的交流，心境也变得平和。但这对母子居住的城镇，却似乎潜伏着神秘的妖怪。在调查此事归来后，寄生于猫咪老师身体的“妖之种”，在藤原家的庭院中，一夜之间就长成树结出果实。而吃掉了与自己形状相似果实的猫咪老师，竟然分裂成了3个",
        //     director: "大森贵弘 /伊藤秀樹",
        //     endDate: null,
        //     id: 10,
        //     language: null,
        //     length: null,
        //     name: "夏目友人帐",
        //     posterUrl: "http://n.sinaimg.cn/translate/640/w600h840/20190312/ampL-hufnxfm4278816.jpg",
        //     screenWriter: "vacity",
        //     starring: "神谷浩史 /井上和彦 /高良健吾 /小林沙苗 /泽城美雪",
        //     startDate: null,
        //     type: "动画"
        // })
        getRequest(
            '/movie/'+movieId + '/' + userId,
            function(res){
                var data = res.content;
                repaintMovieDetail(res.content);
            },
            function (error) {
                alert(error);
            });
    }

    function repaintMovieDetail(movie) {
        $('#movie-img').attr('src',movie.posterUrl);
        $('#movie-name').text(movie.name);
        $('#movie-description').text(movie.description);
        $('#movie-startDate').text(movie.startDate);
        $('#movie-type').text(movie.type);
        $('#movie-country').text(movie.country);
        $('#movie-language').text(movie.language);
        $('#movie-director').text(movie.director);
        $('#movie-starring').text(movie.starring);
        $('#movie-writer').text(movie.screenWriter);
    }

    // user界面才有
    $('#like-btn').click(function () {
        var url = isLike ?'/movie/'+ movieId +'/unlike?userId='+ userId :'/movie/'+ movieId +'/like?userId='+ userId;
        postRequest(
             url,
            null,
            function (res) {
                 isLike = !isLike;
                isLike ? $('.icon-heart').removeClass('error-text') : $('.icon-heart').addClass('error-text');
                $('#like-btn span').text(isLike ? ' 已想看' : ' 想 看');
            },
            function (error) {
                alert(error);
            });
    });

    // admin界面才有
    $("#modify-btn").click(function () {
       alert('后续功能');
    });

});