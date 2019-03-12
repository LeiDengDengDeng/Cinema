$(document).ready(function(){
    var movieList = [{
        name: '流浪地球',
        img: 'https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=c3299fd84c34970a537e187df4a3baad/dcc451da81cb39dbdd0730a1dd160924aa183005.jpg',
        wantWatch: 123,
        description: '《流浪地球》是由中国电影股份有限公司、北京京西文化旅游股份有限公司、北京登峰国际文化传播有限公司、郭帆文化传媒（北京）有限公司出品的科幻片，由郭帆执导，吴京特别出演，屈楚萧、李光洁、吴孟达、赵今麦领衔主演。该片于2019年2月5日（农历大年初一）在中国内地上映。',
        director: '郭帆',
        starring: '吴京，李光洁等',
        type: '动作|奇幻',
        showState: true
    },{
        name: '夏目友人帐',
        img: 'https://img1.doubanio.com/view/photo/l/public/p2434038607.webp',
        wantWatch: 99,
        description: '在人与妖怪之间过着忙碌日子的夏目，偶然与以前的同学结城重逢，由此回忆起了被妖怪缠身的苦涩记忆。此时，夏目认识了在归还名字的妖怪记忆中出现的女性·津村容莉枝。和玲子相识的她，现在和独子椋雄一同过着平稳的生活。夏目通过与他们的交流，心境也变得平和。但这对母子居住的城镇，却似乎潜伏着神秘的妖怪。在调查此事归来后，寄生于猫咪老师身体的“妖之种”，在藤原家的庭院中，一夜之间就长成树结出果实。而吃掉了与自己形状相似果实的猫咪老师，竟然分裂成了3个',
        director: '大森贵弘',
        starring: '神谷浩史,井上和彦',
        type: '动画|奇幻',
        showState: false
    },{
        name: '夏目友人帐',
        img: 'https://img1.doubanio.com/view/photo/l/public/p2434038607.webp',
        wantWatch: 99,
        description: '在人与妖怪之间过着忙碌日子的夏目，偶然与以前的同学结城重逢，由此回忆起了被妖怪缠身的苦涩记忆。此时，夏目认识了在归还名字的妖怪记忆中出现的女性·津村容莉枝。和玲子相识的她，现在和独子椋雄一同过着平稳的生活。夏目通过与他们的交流，心境也变得平和。但这对母子居住的城镇，却似乎潜伏着神秘的妖怪。在调查此事归来后，寄生于猫咪老师身体的“妖之种”，在藤原家的庭院中，一夜之间就长成树结出果实。而吃掉了与自己形状相似果实的猫咪老师，竟然分裂成了3个',
        director: '大森贵弘',
        starring: '神谷浩史,井上和彦',
        type: '动画|奇幻',
        showState: false
    }
    ];

    repaintMovieList();

    function repaintMovieList() {
        var movieDomList ='';
        movieList.forEach(function (movie) {
            movieDomList +=
                "<li class='movie-item card'>" +
                "<img class='movie-img' src='" + movie.img + "'/>" +
                "<div class='movie-info'>" +
                "<p class='movie-title primary-text'>" +
                "<span>" + movie.name + "</span>" +
                "<span class='label "+(movie.showState ? 'primary-bg' : 'error-bg')+"'>" + (movie.showState ? '上映中' : '未上映') + "</span>" +
                "</p>" +
                "<p class='dark-text'>" + (movie.description.length < 160 ? movie.description : (movie.description.substr(0,160) + '...')) + "</p>" +
                "<p>" +
                "<span>导演：" + movie.director + "</span><span style='margin-left: 30px;'>主演：" + movie.starring + "</span></p>" +
                "<p class='movie-type-want'><span>类型：" + movie.type + "</span><span class='movie-want'><i class='icon-heart error-text'></i>" + movie.wantWatch + "人想看</span></p>" +
                "</div>"+
                "</li>";
        });
        $('.movie-on-list').append(movieDomList);
    }
});