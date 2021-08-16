function fetchMusic(value){
    console.log('Tentando reproduzir música com id', value);
    document.getElementById("player_source").src = "http://localhost:8100/music/"+String(value);
    document.getElementById("player").load();
}