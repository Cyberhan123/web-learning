/**
 * @author Cyberhan
 * @param entryJs
 * @param indexJS
 * @param other
 * @returns {*}
 */
module.exports = (entryJs,indexJS,...other) => {
   let arr={
       entry:entryJs,
       index:indexJS
   };
   if(other.length===0){
       other.forEach((elem)=>{
           arr = {...arr,...elem};
       })
   }
    return entryJs;
};