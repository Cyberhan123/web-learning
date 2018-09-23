import React from 'react'
import fetch from 'dva/fetch'
import {List} from 'antd-mobile'
import styles from "../index.css";
const Item =List.Item;

export default class item extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      results: [],
      row: {}
    }
  }

  componentWillMount() {
    fetch("http://www.xiechenxi.cn/welcome/detail/" + this.props.match.params.id).then((resp) => {
      if (resp.state >= 400) {
        throw new Error("Bad response from server");
      }
      return (resp.json());
    }).then((data) => {
      this.setState({
        results: data.results,
        row: data.row,
      })
    }).catch(()=>{
      console.error("未获取到对应json")
    })
  }

  render() {
    let res = this.state.results;
    let row = this.state.row;
    console.log(res, row);
    return (
      <div>
        <img src={row.img} alt="图片未找到"/>
        <h4>{row.business_name}</h4>
        <span>地址：{row.business_address}</span><p>{row.business_tel}</p>
        <span>{row.collect}</span>
        <div>
          <List>
            {res.map((item) =>
              (<Item key={item.user_id}
                     arrow="empty"
                     onClick={() => {
                     }}>{item.username}<br/>{item.content}<span className={styles.listprice}>时间：{item.time}</span>
                </Item>
              ))}
          </List>
        </div>
      </div>

    )
  }


}
