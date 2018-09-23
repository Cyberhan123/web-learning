import {Grid, List, WhiteSpace} from 'antd-mobile';
import router from 'umi/router';

import React from 'react';
import fetch from 'dva/fetch';
import styles from './index.css';
import img1 from './../assets/img/img1.png';
import img2 from './../assets/img/img2.png';
import img3 from './../assets/img/img3.png';
import img4 from './../assets/img/img4.png';
import img5 from './../assets/img/img5.png';
import img6 from './../assets/img/img6.png';
import img7 from './../assets/img/img7.png';
import img8 from './../assets/img/img8.png';
import img9 from './../assets/img/img9.png';
import img10 from './../assets/img/img10.png';

const Item = List.Item;
const Brief = Item.Brief;

class Index extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [
        {
          icon: img1,
          text: "美食"
        },
        {
          icon: img2,
          text: "电影"
        },
        {
          icon: img3,
          text: "酒店"
        },
        {
          icon: img3,
          text: "娱乐"
        },
        {
          icon: img4,
          text: "外卖"
        },
        {
          icon: img5,
          text: "ktv"
        },
        {
          icon: img6,
          text: "周边游"
        },
        {
          icon: img7,
          text: "丽人"
        },
        {
          icon: img8,
          text: "小吃"
        },
        {
          icon: img9,
          text: "机票"
        },
        {
          icon: img10,
          text: "美食"
        },
        {
          icon: img1,
          text: "电影"
        },
        {
          icon: img2,
          text: "美食"
        },
        {
          icon: img3,
          text: "电影"
        }
      ],
      list: []
    };

  };

  componentWillMount() {
    fetch('http://www.xiechenxi.cn').then((response) => {
      if (response.state >= 400) {
        throw new Error("Bad response from server");
      }
      return (response.json());
    }).then((stories) => {
      this.setState({
        list: stories
      })
    });
  };

  render() {
    return (
      <div>
        <Grid data={this.state.data} isCarousel columnNum={5} hasLine={false}/>
        <WhiteSpace size="lg"/>
        <List>
          {this.state.list.map((item) => (
            <Item key={item.product_id}
                  arrow="empty"
                  thumb={item.img}
                  multipleLine={true}
                  onClick={() => {
                    router.push('/detail/'+item.product_id);
                  }}>{item.product_name}<span className={styles.listprice}>月售：{item.num}</span> <Brief>￥{item.price}
              <p>{item.description}</p></Brief>
            </Item>
          ))
          }
        </List>
      </div>
    )
  }
}

export default Index;
