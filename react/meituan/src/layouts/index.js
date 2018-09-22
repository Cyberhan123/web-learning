import {NavBar, Icon, SearchBar} from 'antd-mobile'
import Style from './index.scss';
class BasicLayout extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <NavBar mode="light" leftContent="哈尔滨"
                rightContent={[
                  <Icon key="1" type="ellipsis"/>,
                ]}
                className={Style.navbar}
        >
          <SearchBar placeholder="Search" maxLength={8} />
        </NavBar>
        {this.props.children}
      </div>
    );
  }
}

export default BasicLayout;
