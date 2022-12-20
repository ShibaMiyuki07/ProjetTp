import { IonContent, IonHeader, IonLabel, IonModal, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { render } from '@testing-library/react';
import axios from 'axios';
import { useEffect, useState } from 'react';
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';

const getData = () =>{
  return axios.get("http:localhost:8080/").then((data : any) =>{
    return data.data;
  }).catch((err) =>
  {
     return "Connexion echoue";
  })
}
export const http = axios.create({
  baseURL : "http://localhost:8080/",
  timeout : 1000
})
const Home: React.FC = () => {
  const [isOpen,setIsOpen] = useState(false);
  const [error,setError] = useState("");
  const [item,setItem] = useState([]);
  useEffect(() =>
  {
    http.interceptors.request.use()
    getData().then((data) =>{
      if(data !== error)
      {

      }
      setItem(data)
      
    }
  })
>>>>>>> Stashed changes
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Blank</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Blank</IonTitle>
          </IonToolbar>
<<<<<<< Updated upstream
=======
          <IonModal isOpen={isOpen}>
            <IonLabel>{error}</IonLabel>
          </IonModal>
>>>>>>> Stashed changes
        </IonHeader>
        <ExploreContainer />
      </IonContent>
    </IonPage>
  );
};

export default Home;
