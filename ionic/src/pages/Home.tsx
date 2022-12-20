import { IonButton, IonContent, IonHeader, IonLabel, IonModal, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { useEffect, useState } from 'react';
import axios from "axios";
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';

const Home: React.FC = () => {
  const [data,setData] = useState([]);
  const [erreur,setErreur] = useState("");
  const [isOpen,setIsOpen] = useState(false);
  useEffect(() =>
  {
    axios.get("autre/test").then(data =>{
      console.log(data.data);
      console.log(data.request['status']);
      if(data.request['status'] !== 200)
      {
        setIsOpen(true);
        setErreur("Veuillez vous connecter");
      }
      else
      {
        setData(data.data);
      }
    }).catch((err) =>
    {
      setIsOpen(true);
      setErreur("Veuillez vous connecter");
    })
  })
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
        </IonHeader>
        <IonModal isOpen={isOpen}>
          <IonLabel>{erreur}</IonLabel>
          <IonButton>OK</IonButton>
        </IonModal>
      </IonContent>
    </IonPage>
  );
};

export default Home;
