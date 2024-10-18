import React from 'react'

const styles = {
    wrapper : {
        margin: 8, 
        padding: 8, 
        display: "flex", 
        flexDirection: "row",
        border: "1px solid gray",
        borderRadius: 16,
    },
    image: {
        width: 50,
        height: 50,
        borderRadius: 25,
    },
    contentContainer: {
        marginLeft: 8,
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        fontSize: 16,
        alignItems : "flex-start",
        color: "black",
    },
    nameText:{
        fontWeight: "bold",
    },
}

function Comment(props) {
  return (
    <div style={styles.wrapper}>
        <div>
            <img src={props.path}
                 alt="프로필이미지" 
                 style={styles.image}/>
        </div>
        <div style={styles.contentContainer}>
            <span style={styles.nameText}>{props.name}</span>
            <span>{props.comment}</span>
        </div>
    </div>
  )
}

export default Comment