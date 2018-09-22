const add =(num)=>{
    console.log('触发add action');
    return{
        type:'ADD_ACTION',
        text:num,
    }
};
export default add;