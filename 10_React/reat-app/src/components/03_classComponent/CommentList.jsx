import React, { Component } from 'react'
import Comment from './Comment'

const serverComments = [
    {
        id: 1,
        message: "안녕하세요. 최지원입니다."
    }, {
        id: 2,
        message: "안녕하세요. 종강일은 12/12입니다"
    }, { 
        id: 3,
        message: "11월은 쉬는 날이 없습니다."
    }
]

class CommentList extends Component {

    constructor(props) {
        super(props)

        this.state = {
            commentList: [],
        }
    }

    componentDidMount(){
       // const commetList = this.state.commentList
       //const data1 = this.state.data1
       //const data2 = this.state.data2

       //const { commetList, data1, data2 } = this.state; //비구조할당

        const {commentList} = this.state;


        //setInterval : 일정시간마다 특정함수를 반복해서 실행
        setInterval(() => {
            if(commentList.length < serverComments.length){ //더미데이터 길이만큼 state내의 데이터가 추가되면 그만하기위한 조건
                const index = commentList.length; // 0 1 2
                commentList.push(serverComments[index]);
                this.setState({
                    commentList : commentList
                })
            } else {
                this.setState({
                    commentList: []
                })
            }
        }, 3000);
    }   

    render() {
        return (
            <div>
                {
                    this.state.commentList.map(c => {
                        return (
                            <Comment key={c.id}
                                     id={c.id}
                                     message={c.message}
                            />
                        )
                    })
                }
            </div>
        )
    }
}

export default CommentList
