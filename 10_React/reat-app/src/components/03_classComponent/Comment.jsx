import PropTypes from 'prop-types'
import React, { Component } from 'react'

/*
    class Componet
    state(필드대체)를 가지고있고 이를 수정할 수 있다.
    라이프사이클에따른 생명주기 메서드를 사용할 수 있다.
*/

const styles = {
    wrapper : {
        margin: 8, 
        padding: 8, 
        display: "flex", 
        flexDirection: "row",
        border: "1px solid gray",
        borderRadius: 16,
    },
    commentText: {
        fontSize: 18,
    }
}


class Comment extends Component {
  constructor(props){
    super(props)

    //js에서는 class에 필드영역이 없기때문에
    //저장하고싶은 데이터를 state라는 객체에 key-value형태로 저장한다.
    this.state = {}
  }

  componentDidMount(){
    console.log("componentDidMount 실행됨")
  }

  componentDidUpdate(){
    console.log("componentDidUpdate 실행됨")
  }

  componentWillUnmount(){
    console.log("componentWillUnmount 실행됨")
  }

  render() {
    return (
      <div style={styles.wrapper}>
        <span style={styles.commentText}>
            안녕하세요 최지원입니다.
        </span>
      </div>
    )
  }
}

export default Comment
