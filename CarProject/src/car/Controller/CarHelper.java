package car.Controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import car.Model.CarEntity;

public class CarHelper {

		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarProject");

		public void insertCarEntity(CarEntity CarEntity) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(CarEntity);
			em.getTransaction().commit();
			em.close();
		}

		public List<CarEntity> showAllCarEntitys() {
			EntityManager em = emfactory.createEntityManager();
			List<CarEntity> allCarEntitys = em.createQuery("SELECT i FROM CarEntity i").getResultList();
			return allCarEntitys;
		}

		public void deleteCarEntity(CarEntity toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CarEntity> typedQuery = em.createQuery("select c from CarEntity c where c.make = :selectedMake and c.model = :selectedModel and c.year = :selectedYear", CarEntity.class);

			typedQuery.setParameter("selectedMake", toDelete.getMake());
			typedQuery.setParameter("selectedModel", toDelete.getModel());
			typedQuery.setParameter("selectedYear", toDelete.getYear());

			typedQuery.setMaxResults(1);

			CarEntity result = typedQuery.getSingleResult();

			//remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}

		public CarEntity searchForCarEntityById(int idToEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			CarEntity found = em.find(CarEntity.class, idToEdit);
			em.close();
			return found;
		}

		public void updateCarEntity(CarEntity toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}

		public List<CarEntity> searchForCarEntityByMake(String make) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CarEntity> typedQuery = em.createQuery("select c from CarEntity c where c.make = :selectedMake", CarEntity.class);
			typedQuery.setParameter("selectedMake", make);

			List<CarEntity> foundCarEntitys = typedQuery.getResultList();
			em.close();
			return foundCarEntitys;
		}

		public List<CarEntity> searchForCarEntityByModel(String model) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CarEntity> typedQuery = em.createQuery("select c from CarEntity c where c.model = :selectedModel", CarEntity.class);
			typedQuery.setParameter("selectedModel", model);

			List<CarEntity> foundCarEntitys = typedQuery.getResultList();
			em.close();
			return foundCarEntitys;
		}
		public List<CarEntity> searchForCarEntityByYear(String year) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CarEntity> typedQuery = em.createQuery("select c from CarEntity c where c.year = :selectedYear", CarEntity.class);
			typedQuery.setParameter("selectedYear", year);

			List<CarEntity> foundCarEntitys = typedQuery.getResultList();
			em.close();
			return foundCarEntitys;
		}
		public void cleanUp() {
			emfactory.close();
		}
	}
