function search() {
    let searchBtn = $('.search-icon');
    let searchText = $('#searchText')
    searchBtn.click(function () {

        if ( /^[\u4e00-\u9fa50-9]+$/.test(searchText.val()))
        {
            location.href='/games/search?name='+searchText.val()+'&pageNum=1&pageSize=13'
        }else  if (/^[a-zA-Z0-9]+$/.test(searchText.val())){
            location.href='/games/search?engName='+searchText.val()+'&pageNum=1&pageSize=13'
        }else
        {
            location.href='/games/search?name='+searchText.val()+'&pageNum=1&pageSize=13'
        }
    })
}