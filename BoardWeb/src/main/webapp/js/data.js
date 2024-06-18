/**
 * data.js
 */
const myMembers = [
	{id: 'user01', name: '홍길동', phone:'010-1111-2222', point: 90}, //new Object();
	{id : 'user02', name: '박석민', phone:'010-2222-3333', point: 95},
	{id : 'user03', name: '김시후', phone:'010-3333-4444', point: 120}
]; //배열선언(또는 new Array(); 해도 됨)

const json = `[{"id":1,"first_name":"Prisca","last_name":"Blaby","email":"pblaby0@so-net.ne.jp","gender":"Female","salary":3847},
{"id":2,"first_name":"Marion","last_name":"Bastick","email":"mbastick1@gmpg.org","gender":"Female","salary":6097},
{"id":3,"first_name":"Joseito","last_name":"Allott","email":"jallott2@twitter.com","gender":"Male","salary":6962},
{"id":4,"first_name":"Cosmo","last_name":"Gooderick","email":"cgooderick3@boston.com","gender":"Male","salary":7562},
{"id":5,"first_name":"Harmonie","last_name":"Ibbeson","email":"hibbeson4@devhub.com","gender":"Female","salary":4912},
{"id":6,"first_name":"Persis","last_name":"Faldo","email":"pfaldo5@de.vu","gender":"Female","salary":6943},
{"id":7,"first_name":"Madelena","last_name":"Naseby","email":"mnaseby6@gizmodo.com","gender":"Female","salary":6283},
{"id":8,"first_name":"Sasha","last_name":"Keelinge","email":"skeelinge7@arizona.edu","gender":"Male","salary":5281},
{"id":9,"first_name":"John","last_name":"Hardistry","email":"jhardistry8@fotki.com","gender":"Male","salary":6360},
{"id":10,"first_name":"Yetta","last_name":"Girk","email":"ygirk9@imdb.com","gender":"Female","salary":4495},
{"id":11,"first_name":"Bertina","last_name":"Daintree","email":"bdaintreea@google.co.jp","gender":"Female","salary":6490},
{"id":12,"first_name":"Bambie","last_name":"Turl","email":"bturlb@hibu.com","gender":"Female","salary":4992},
{"id":13,"first_name":"Orelle","last_name":"Baudry","email":"obaudryc@bing.com","gender":"Female","salary":5912},
{"id":14,"first_name":"Archaimbaud","last_name":"Drillingcourt","email":"adrillingcourtd@hp.com","gender":"Male","salary":5023},
{"id":15,"first_name":"Ophelia","last_name":"Matusov","email":"omatusove@who.int","gender":"Female","salary":6737}]`;

const employees = JSON.parse(json);
