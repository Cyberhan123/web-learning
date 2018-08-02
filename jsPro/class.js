function Father() {
    this.name = 'xxx';
}

//原型对象
Father.prototype.eat = function () {
    console.log(this.name);
};
var p = new Father();
p.eat();

function Son(age) {
    this.age = age;
    console.log(this.age);
}
//继承
Son.prototype = new Father();

var s = new Son(1234);
s.eat();
//所有new 的对象会共享变量
