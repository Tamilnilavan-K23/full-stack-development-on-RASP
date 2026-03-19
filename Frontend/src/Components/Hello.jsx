//const name = "tamilnilavan";

/* function displaymessage() {
  return "this is additional functional message";
} */
function Hello(props) {
  //return <h2>this is components page {name}</h2>;

  /* return (
    <div>
      <h2>this is components page from {name}</h2>

      {displaymessage()}
    </div>
  ); */

  return (
    <div>
      <h2>this is components page from {props.name}</h2>
      {props.message}
    </div>
  );


}

export default Hello;
